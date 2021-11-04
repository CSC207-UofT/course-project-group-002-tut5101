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
    private static final HashMap<String, Inventory> myDict = new HashMap<>();


    /**
     * Add new Inventory item to myDict.
     * @param item The inventory to add
     */
    public void addInventory(Inventory item){
        if(!(myDict.containsKey(item.getName()) || myDict.containsValue(item))){myDict.put(item.getName(), item);}
    }

    public void loadHashMap(HashMap hashMap){
        if(myDict.isEmpty()){myDict.putAll(hashMap);}
    }

    public boolean checkExist(String name){return myDict.containsKey(name);}
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



    /**
     *
     * @param name The name of the ingredient being changed
     * @param newFreshness the new freshness for this ingredient.
     */



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
