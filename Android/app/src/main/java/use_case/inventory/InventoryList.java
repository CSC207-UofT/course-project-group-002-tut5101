package use_case.inventory;

import android.annotation.SuppressLint;
import android.content.Context;
import constant.file_system.FileName;
import entity.inventory.HasFreshness;
import entity.inventory.Inventory;
import gateway.GCloudReadWriter;
import gateway.ReadWriter;
import use_case.inventory.boundary.InventoryOutputBoundary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * Public class storing information for all inventories using a Hashmap.
 */
public class InventoryList implements Serializable {

    /**
     * A hashmap that maps ingredient name to its corresponding inventory item instance.
     * The information of this ingredient (e.g. name, price, quantity, etc.) are stored as
     * attribute in the inventory item instance.
     */
    private static HashMap<String, Inventory> myDict;
    private static final ReadWriter irw = new GCloudReadWriter();

    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private InventoryOutputBoundary boundary;
    private static String filename;

    private static final long serialVersionUID = 1L;

    /**
     * Null constructor
     */
    public InventoryList() {
        if (myDict == null) {
            myDict = new HashMap<>();
        }
    }

    /**
     * Set output boundary interface
     *
     * @param boundary output boundary interface
     */
    public void setBoundary(InventoryOutputBoundary boundary) {
        this.boundary = boundary;
    }

    /**
     * Add new Inventory item to myDict.
     *
     * @param item The inventory to add
     */
    public String addInventory(Inventory item) {
        if (!(myDict.containsKey(item.getName()) || myDict.containsValue(item))) {
            int id = myDict.size();
            item.setId(id);
            myDict.put(item.getName(), item);
            saveToFile();
            return "Successful";
        } else {
            return "Occupied name or item";
        }
    }


    /**
     * Add a new inventory item by creating from the inventory Factory with the given string
     * parameters.
     *
     * @param inf   an InventoryFactory instance
     * @param paras The given String parameters needed to create it.
     */
    public String addFromFactory(InventoryFactory inf, String[] paras) {
        return addInventory(inf.getInventory(paras));
    }


    /**
     * Check if an ingredient is in the inventoryList, return true if present
     *
     * @param name Name of the ingredient
     * @return true only if the ingredient with name is found in the list
     */
    public boolean checkExist(String name) {
        return myDict.containsKey(name);
    }


    /**
     * @param name The name of the inventory item to be returned info
     * @return The string information of the inventory item.
     * <p>
     * This method should only be called after checkExist to ensure not error occur.
     */
    public String getInfo(String name) {
        return Objects.requireNonNull(myDict.get(name)).toString();
    }


    /**
     * @param name the inventory item whose type will be checked
     * @return whether the given inventory item has freshness or not.
     */
    public boolean isHasFreshness(String name) {
        return myDict.get(name) instanceof HasFreshness;
    }


    /**
     * Set the freshness of the given inventory item
     *
     * @param name The name of an inventory item
     *             <p>
     *             NOTE: This method should only be called after the isHasFreshness check.
     */
    public void setFreshness(String name, String newFreshness) {
        if (myDict.get(name) instanceof HasFreshness) {
            ((HasFreshness) Objects.requireNonNull(myDict.get(name))).setFreshness(newFreshness);
            saveToFile();
        }
    }


    /**
     * Get the quantity of inventory by its name
     *
     * @param name The name of this inventory
     * @return the quantity of inventory required.
     */
    public static int getTotalQuantity(String name) {
        if (!myDict.containsKey(name)) {
            return 0;
        }
        return Objects.requireNonNull(myDict.get(name)).getQuantity();
    }

    /**
     * @param name  The name of the ingredient being changed
     * @param usage the quantity used for this ingredient.
     */
    public String setQuantity(String name, int usage) {
        if (!myDict.containsKey(name)) {
            return "wrong name";
        }
        String result = Objects.requireNonNull(myDict.get(name)).updateQuantity(usage);
        saveToFile();
        return result;
    }

    public String passNewQuantityInfo(String name, int usage) {
        String info = this.setQuantity(name, usage);
        return boundary.getMessage(info);
    }

    /**
     * Save data to file
     */
    public void saveToFile() {
        irw.saveToFile(context, filename, myDict);
    }

    /**
     * Setting context
     *
     * @param context context
     */
    public static void setContext(Context context) {
        InventoryList.context = context;
    }

    /**
     * Set the data
     *
     * @param filename name of file
     */
    @SuppressWarnings("unchecked")
    public static void setData(String filename) {
        InventoryList.filename = filename;
        if (myDict == null || myDict.isEmpty()) {
            myDict = (HashMap<String, Inventory>) irw.readFromFile(FileName.INVENTORY_FILE);
        }
    }
}
