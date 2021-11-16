package controller;


import constant.FileLocation;
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

    public InventoryManager(String filepath){
        this.filepath = filepath;
        this.map = irw.readFromFile(filepath);
        this.inventorys = new InventoryList(this.map);
    }

    public InventoryManager(String filepath,HashMap map){
        this.filepath = filepath;
        this.map = map;
        this.inventorys = new InventoryList(this.map);
    }

    public String getInfo(String name){
        if(this.inventorys.checkExist(name)){
        return this.inventorys.getInfo(name);}
        else{return "Invalid name";}
    }

    public void addNewInventory(String[] para){
        this.inventorys.addFromFactory(this.infc, para);
    }


    public void newFreshness(String name, String newFreshness){
        if(this.inventorys.isHasFreshness(name)){
            this.inventorys.setFreshness(name, newFreshness);
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
