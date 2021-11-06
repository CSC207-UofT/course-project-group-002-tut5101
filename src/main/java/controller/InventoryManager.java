package controller;

import constant.FileLocation;
import entity.HasFreshness;
import entity.Inventory;
import gateway.InventoryReadWriter;
import use_case.InventoryFactory;
import use_case.InventoryList;

import java.util.HashMap;

public class InventoryManager {
    private InventoryList inventorys;
    private final InventoryReadWriter irw = new InventoryReadWriter();
    private final InventoryFactory infc = new InventoryFactory();
    private final String filepath;
    private HashMap map;

    public InventoryManager(){
        this.filepath = FileLocation.INVENTORY_FILE_LOCATION;
        this.map = irw.readFromCSV("src/main/resources/inventorydata.csv");
        this.inventorys = new InventoryList(this.map);
    }

    public InventoryManager(String filepath, HashMap map){
        this.filepath = filepath;
        this.map = map;
        this.inventorys = new InventoryList(this.map);
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

    public void SavetoFile(){
        this.irw.saveToFile(this.filepath, this.map);
    }


}
