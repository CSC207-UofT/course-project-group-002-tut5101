package entities;

import java.util.HashMap;

public class InventoryList {
    public String name;
    private HashMap<String, Inventory> MyDict;

    public InventoryList(String name){
        this.name = name;
        this.MyDict = new HashMap<>();
    }

    public void AddInventory(Inventory item){
        this.MyDict.put(item.name, item);
    }

    public  Inventory GetItem(String name){
        return this.MyDict.get(name);
    }

}
