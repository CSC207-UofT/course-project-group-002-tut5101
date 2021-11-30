package controller.inventorysystem;


import constant.filesystem.FileLocation;
import use_case.boundary.output.InventoryOutputBoundary;
import use_case.inventoryfactory.InventoryFactory;
import use_case.kitchen.InventoryList;

public class InventoryManager {
    private final InventoryList inventories;

    private final InventoryFactory infc = new InventoryFactory();
    private final String filepath;

    public InventoryManager( ){
        this.filepath = FileLocation.INVENTORY_FILE_LOCATION;
        this.inventories = new InventoryList();
    }

    public InventoryManager(String filepath){
        this.filepath = filepath;
        this.inventories = new InventoryList();
    }



    public String getInfo(String name){
        if(this.inventories.checkExist(name)){
        return this.inventories.getInfo(name);}
        else{return "Invalid name";}
    }

    public void addNewInventory(String[] para){
        this.inventories.addFromFactory(this.infc, para);
    }


    public String newFreshness(String name, String newFreshness){
        String message;
        if(this.inventories.isHasFreshness(name)){
            this.inventories.setFreshness(name, newFreshness);
            message = "updated";
        }
        else{message = "item does not have freshness";}
        return message;
    }

    public String newQuantity(String name, String usage,InventoryOutputBoundary boundary){
        this.inventories.setBoundary(boundary);
        double u = Double.parseDouble(usage);
        return inventories.setQuantity(name, u);
    }

//    public void SavetoFile(){
//        this.inventories.SavetoFile();
//    }



}
