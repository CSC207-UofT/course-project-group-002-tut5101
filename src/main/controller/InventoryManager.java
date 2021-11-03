package controller;

import entity.Inventory;
import use_case.InventoryList;
import gateway.InvReadandWrite;

;

public class InventoryManager {
    private final InventoryList inventorys;
    private final InvReadandWrite filehelper = new InvReadandWrite();
    private final String filepath;

    public InventoryManager(String filepath){
        this.filepath = filepath;
        this.inventorys = filehelper.read(filepath);
    }

    public String getinfo(String name){
        return this.inventorys.getItem(name).toString();
    }

    public void newinventory(Inventory item){
        this.inventorys.addInventory(item);
        String item_string = item.toString();
        this.filehelper.addinfo(this.filepath, item_string);
    }

    public void newFreshness(String name, String newfreshness){
        Inventory item = this.inventorys.getItem(name);
        String itemstring = item.toString();
        this.inventorys.updateFreshness(name, newfreshness);
        Inventory newitem = this.inventorys.getItem(name);
        String itemstring1 = newitem.toString();
        this.filehelper.changeinfo(this.filepath, itemstring, itemstring1);
    }

    public void newQuantity(String name, double usage){
        Inventory item = this.inventorys.getItem(name);
        String itemstring = item.toString();
        this.inventorys.setQuantity(name, usage);
        Inventory newitem = this.inventorys.getItem(name);
        String itemstring1 = newitem.toString();
        this.filehelper.changeinfo(this.filepath, itemstring, itemstring1);
    }


}
