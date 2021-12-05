package use_case.kitchen;

import android.annotation.SuppressLint;
import android.content.Context;
import constant.file_system.FileLocation;
import entity.inventory.HasFreshness;
import entity.inventory.Inventory;
import gateway.GCloudReadWriter;
import gateway.ReadWriter;
import use_case.inventory_factory.InventoryOutputBoundary;
import use_case.inventory_factory.InventoryFactory;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * Public class storing information for all inventories using a Hashmap.
 *
 */
public class InventoryList implements Serializable {

    /**
     * A hashmap that maps ingredient name to its corresponding inventory item instance.
     * The information of this ingredient (e.g. name, price, quantity, etc.) are stored as
     * attribute in the inventory item instance.
     */
    private static HashMap<String, Inventory> myDict;
    private final ReadWriter irw;

    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private InventoryOutputBoundary boundary;
    private String filename;

    public InventoryList(String filename) {
        this.filename = filename;
        irw = new GCloudReadWriter();
        myDict = (HashMap<String, Inventory>) irw.readFromFile(FileLocation.INVENTORY_FILE);
    }

    public void setBoundary(InventoryOutputBoundary boundary) {
        this.boundary = boundary;
    }

    /**
     * Add new Inventory item to myDict.
     * @param item The inventory to add
     */
    public String addInventory(Inventory item){
        if(!(myDict.containsKey(item.getName()) || myDict.containsValue(item)))

        {   int id = myDict.size();
            item.setId(id);
            myDict.put(item.getName(), item);
            return "Successful";
        }
        else{return "Occupied name or item";}
    }


    /**
     * Add a new inventory item by creating from the inventory Factory with the given string
     * parameters.
     *
     * @param inf an InventoryFactory instance
     * @param paras The given String parameters needed to create it.
     */
    public String addFromFactory(InventoryFactory inf, String[] paras) {
        return addInventory(inf.getInventory(paras));
    }


    /**
     * Check if an ingredient is in the inventoryList, return true if present
     * @param name Name of the ingredient
     * @return true only if the ingredient with name is found in the list
     */
    public boolean checkExist(String name){return myDict.containsKey(name);}


    /**
     * @param name The name of the inventory item to be returned info
     * @return The string information of the inventory item.
     *
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
     *
     * NOTE: This method should only be called after the isHasFreshness check.
     */
    public void setFreshness(String name, String newFreshness) {
        ((HasFreshness) Objects.requireNonNull(myDict.get(name))).setFreshness(newFreshness);
    }


    /**
     * Get the quantity of inventory by its name
     * @param name The name of this inventory
     * @return the quantity of inventory required.
     */
    public static int getTotalQuantity(String name){
        if (!myDict.containsKey(name)){
            //TODO: implement exceptions for cases of wrong key
            return 0;
        }
        return Objects.requireNonNull(myDict.get(name)).getQuantity();
    }

    /**
     *
     * @param name The name of the ingredient being changed
     * @param usage the quantity used for this ingredient.
     */
    public String setQuantity(String name, int usage) {
        if (!myDict.containsKey(name)){
            return "wrong name";
        }
        return this.boundary.getMessage(Objects.requireNonNull(myDict.get(name)).updateQuantity(usage));
    }

    public void saveToFile() {
        irw.saveToFile(context, filename, myDict);
    }

    /**
     * Generate data for inventoryList.
     */
    public void generateData() {
    }

    /**
     * Setting context
     * @param context context
     */
    public static void setContext(Context context) {
        InventoryList.context = context;
    }
}
