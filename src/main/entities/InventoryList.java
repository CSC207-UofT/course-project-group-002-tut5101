package entities;

import java.util.HashMap;

public class InventoryList {


    /**
     * A hashmap that maps ingredient name to its corresponding inventory item instance.
     * The information of this ingredient (e.g. name, price, quantity, etc.) are stored as
     * attribute in the inventory item instance.
     */
    private static HashMap<String, Inventory> myDict = new HashMap<>();

    /**
     * Add new Inventory item to myDict.
     * @param item The inventory to add
     */
    public static void addInventory(Inventory item){
        myDict.put(item.name, item);
    }


    /**
     * Get the inventory by its name
     * @param name The name of this inventory
     * @return the inventory required.
     */
    public static Inventory getItem(String name){
        return myDict.get(name);
    }

    public static String getFreshness(String name){
        if(getItem(name) instanceof Material){
            Material i = (Material) getItem(name);
            return i.getFreshness();
        }
        else{
            // TODO: what would be a better way to access the freshness of inventory item.
            return null;
        }
    }

    public static void updateFreshness(String name, String newFreshness) {
        if(getItem(name) instanceof Material){
            Material i = (Material) getItem(name);
            i.setFreshness(newFreshness);
        }
        // TODO: handle cases when the given name is not an ingredient with freshness
    }

    public static double getTotalQuantity(String name){
        if (!myDict.containsKey(name)){
            //TODO: implement exceptions for cases of wrong key
            return 0;
        }
        return getItem(name).getQuantity();
    }

    /**
     *
     * @param name The name of the ingredient being changed
     * @param quantity the quantity used for this ingredient.
     */
    public static void setQuantity(String name, double quantity) {
        if (!myDict.containsKey(name)){
            //TODO: implement exceptions for cases of wrong key
            return;
        }
        getItem(name).quantity = quantity;
    }


}
