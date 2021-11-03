package controller;

import entity.HasFreshness;
import entity.Inventory;
import gateway.InventoryReadWriter;
import use_case.InventoryFactory;
import use_case.InventoryList;

public class InventoryManager {
    private final InventoryList inventorys;
    private final InventoryReadWriter irw = new InventoryReadWriter();
    private final InventoryFactory infc = new InventoryFactory();
    private final String filepath;

    public InventoryManager(){
        this.filepath = "src/initialdata.ser";
        this.inventorys = irw.readFromFile(filepath);
    }

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

    public String getInfo(String name){
        if(this.inventorys.checkExist(name)){
        return this.inventorys.getItem(name).toString();}
        else{return "Invalid name";}
    }

    public void addNewInventory(String[] para){
        this.inventorys.addInventory(this.infc.getInventory(para));
    }

    public String currentFreshness(String name){
        if(getInventory(name) instanceof HasFreshness){
            HasFreshness i = (HasFreshness) getInventory(name);
            return i.getFreshness();
        }
        else{
            return null;
        }
    }


    public void newFreshness(String name, String newFreshness){
        if(getInventory(name) instanceof HasFreshness){
            HasFreshness i = (HasFreshness) getInventory(name);
            i.setFreshness(newFreshness);
        }
    }

    public void newQuantity(String name, String usage){
        double u = Double.parseDouble(usage);
        InventoryList.setQuantity(name, u);
    }


}
