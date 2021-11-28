package controller.inventorySystem;


import constant.fileSystem.FileLocation;
import use_case.inventoryFactory.InventoryFactory;
import use_case.kitchen.InventoryList;

public class InventoryManager {
    private final InventoryList inventories;

    private final InventoryFactory infc = new InventoryFactory();
    private final String filepath;

    public InventoryManager(){
        this.filepath = FileLocation.INVENTORY_FILE_LOCATION;
        this.inventories = new InventoryList(filepath);
    }

    public InventoryManager(String filepath){
        this.filepath = filepath;
        this.inventories = new InventoryList(filepath);
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

    public String newQuantity(String name, String usage){
        double u = Double.parseDouble(usage);
        return InventoryList.setQuantity(name, u);
    }

    public void SavetoFile(){
        this.inventories.SavetoFile();
    }


}
