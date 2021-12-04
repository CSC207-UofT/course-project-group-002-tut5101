package presenter.kitchen_system;

import constant.file_system.FileLocation;
import controller.KitchenController;
import use_case.kitchen.InventoryList;

/**
 *
 */
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
