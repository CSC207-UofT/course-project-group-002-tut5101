package UseCase;

import entities.*;


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
        if(!(myDict.containsKey(item.name) || myDict.containsValue(item))){myDict.put(item.name, item);}
    }


    /**
     * Get the inventory by its name
     * @param name The name of this inventory
     * @return the inventory required.
     */
    public static Inventory getItem(String name){
        return myDict.get(name);
    }

    /**
     * Get the freshness of inventory by its name
     * @param name The name of this inventory
     * @return the freshness of inventory required.
     */

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

    /**
     *
     * @param name The name of the ingredient being changed
     * @param newFreshness the new freshness for this ingredient.
     */

    public static void updateFreshness(String name, String newFreshness) {
        if(getItem(name) instanceof Material){
            Material i = (Material) getItem(name);
            i.setFreshness(newFreshness);
        }
        // TODO: handle cases when the given name is not an ingredient with freshness
    }

    /**
     * Get the quantity of inventory by its name
     * @param name The name of this inventory
     * @return the quantity of inventory required.
     */


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
     * @param usage the quantity used for this ingredient.
     */
    public static void setQuantity(String name, double usage) {
        if (!myDict.containsKey(name)){
            //TODO: implement exceptions for cases of wrong key
            return;
        }
        getItem(name).updateQuantity(usage);
    }


}
