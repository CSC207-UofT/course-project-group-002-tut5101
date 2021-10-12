package entities;

import java.util.HashMap;

public class InventoryList {


    public String name;
    private HashMap<String, Inventory> MyDict;

    /**
     * Construct an instance of InventoryList
     * @param name The name of the Inventory
     */

    public InventoryList(String name){
        this.name = name;
        this.MyDict = new HashMap<>();
    }

    /**
     * Add new Inventory and its name into InventoryList
     * @param item The inventory to add
     */

    public void addInventory(Inventory item){
        this.MyDict.put(item.name, item);
    }

    /**
     * Get the Iventory by its name
     * @param name The name of this inventory
     * @return the inventory required.
     */

    public Inventory getItem(String name){
        return this.MyDict.get(name);
    }

    public String getFreshness(String name){
        if(this.getItem(name) instanceof Material){
            Material i = (Material) this.getItem(name);
            return i.getFreshness();
        }
        else{return "No freshness for this";}}

    public double getCurrentQuantity(String name){
        return this.getItem(name).getQuantity();
    }


}
