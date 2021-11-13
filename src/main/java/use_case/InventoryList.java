package use_case;

import entity.*;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;


public class InventoryList implements Serializable {


    /**
     * A hashmap that maps ingredient name to its corresponding inventory item instance.
     * The information of this ingredient (e.g. name, price, quantity, etc.) are stored as
     * attribute in the inventory item instance.
     */
    private static HashMap<String, Inventory> myDict;

    public InventoryList(){ myDict = new HashMap<>();}

    public InventoryList(HashMap map){myDict = map;}


    /**
     * Add new Inventory item to myDict.
     * @param item The inventory to add
     */
    public void addInventory(Inventory item){
        if(!(myDict.containsKey(item.getName()) || myDict.containsValue(item))){myDict.put(item.getName(), item);}
    }


    /**
     * Add a new inventory item by creating from the inventory Factory with the given string
     * parameters.
     *
     * @param inf an InventoryFactory instance
     * @param paras The given String parameters needed to create it.
     */
    public void addFromFactory(InventoryFactory inf, String[] paras) {
        addInventory(inf.getInventory(paras));
    }


    /**
     * Check if the inventoryList is empty
     * @return true when the inventoryList is empty
     */
    public boolean checkEmpty(){return myDict.isEmpty();}

    /**
     * Check if an ingredient is in the inventoryList, return true if present
     * @param name Name of the ingredient
     * @return true only if the ingredient with name is foudn in the list
     */
    public boolean checkExist(String name){return myDict.containsKey(name);}


    /**
     * @param name The name of the inventory item to be returned info
     * @return The string information of the inventory item.
     *
     * This method should only be called after checkExist to ensure not error occur.
     */
    public String getInfo(String name) {
        return myDict.get(name).toString();
    }


    /**
     * @param name the inventory item whose type will be checked
     * @return whether the given inventory item has freshness or not.
     */
    public boolean isHasFreshness(String name) {
        return myDict.get(name) instanceof HasFreshness;
    }


    /**
     * @param name an inventory item
     * @return The freshness of this given item.
     *
     * NOTE: This method should only be called after the isHasFreshness check.
     */
    public String getFreshness(String name) {
        return ((HasFreshness) myDict.get(name)).getFreshness();
    }


    /**
     * Set the freshness of the given inventory item
     *
     * @param name The name of an inventory item
     *
     * NOTE: This method should only be called after the isHasFreshness check.
     */
    public void setFreshness(String name, String newFreshness) {
        ((HasFreshness) myDict.get(name)).setFreshness(newFreshness);
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
