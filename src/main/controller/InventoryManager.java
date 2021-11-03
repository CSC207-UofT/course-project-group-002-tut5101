package controller;

import entity.Inventory;
import gateway.InventoryReadWriter;
import use_case.InventoryList;

public class InventoryManager {
    private final InventoryList inventorys;
    private final InventoryReadWriter irw = new InventoryReadWriter();
    private final String filepath;

    public InventoryManager(String filepath){
        this.filepath = filepath;
        this.inventorys = irw.readFromFile(filepath);
    }

    public InventoryManager(String filepath, String CSVpath){
        this.filepath = filepath;
        this.inventorys = irw.readFromFile(filepath);
        this.inventorys.loadHashMap(irw.readFromCSV(CSVpath));
    }


    public Inventory getInventory(String name){
        return this.inventorys.getItem(name);
    }

    public void addNewInventory(Inventory item){
        this.inventorys.addInventory(item);
    }
    public String currentFreshness(String name){return this.inventorys.getFreshness(name); }

    public double currentQuantity(String name) {return this.inventorys.getTotalQuantity(name);}


    public void newFreshness(String name, String newfreshness){
        this.inventorys.updateFreshness(name, newfreshness);
    }

    public void newQuantity(String name, double usage){
        this.inventorys.setQuantity(name, usage);
    }


}
