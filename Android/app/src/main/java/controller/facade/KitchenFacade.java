package controller.facade;

import constant.filesystem.FileLocation;
import controller.kitchensystem.KitchenController;
import use_case.kitchen.InventoryList;

public class KitchenFacade {
    final String filepath = FileLocation.INVENTORY_FILE_LOCATION;
    final InventoryList inventoryList;

    public KitchenFacade(){
        this.inventoryList = new InventoryList();
    }

    public KitchenController createKitchen(){
        return new KitchenController(this.inventoryList);
    }
}
