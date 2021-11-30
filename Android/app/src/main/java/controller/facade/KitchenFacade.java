package controller.facade;

import constant.filesystem.FileLocation;
import controller.kitchensystem.KitchenController;
import use_case.kitchen.InventoryList;

public class KitchenFacade {
    String filepath = FileLocation.INVENTORY_FILE_LOCATION;
    InventoryList inventoryList;

    public KitchenFacade(){
        this.inventoryList = new InventoryList(filepath);
    }

    public KitchenController createKitchen(){
        return new KitchenController(this.inventoryList);
    }
}
