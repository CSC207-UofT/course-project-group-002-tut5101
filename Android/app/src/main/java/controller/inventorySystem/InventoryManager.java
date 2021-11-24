package controller.inventorySystem;


import constant.fileSystem.FileLocation;
import use_case.inventoryFactory.InventoryFactory;
import use_case.kitchen.InventoryList;

import java.util.HashMap;

public class InventoryManager {
    private InventoryList inventorys;

    private final InventoryFactory infc = new InventoryFactory();
    private final String filepath;

    public InventoryManager(){
        this.filepath = FileLocation.INVENTORY_FILE_LOCATION;
        this.inventorys = new InventoryList(filepath);
    }

    public InventoryManager(String filepath){
        this.filepath = filepath;
        this.inventorys = new InventoryList(filepath);
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
        this.inventorys.savetoFile();
    }


}
