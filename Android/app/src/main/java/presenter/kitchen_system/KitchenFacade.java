package presenter.kitchen_system;

import constant.file_system.FileLocation;
import controller.KitchenController;
import use_case.kitchen.InventoryList;

/**
 * The Facade used to create KitchenController
 */
public class KitchenFacade {
    final String filepath = FileLocation.INVENTORY_FILE_LOCATION;
    final InventoryList inventoryList;
    /**
     * Constructor for this class.
     */
    public KitchenFacade(){
        this.inventoryList = new InventoryList();
    }
    /**
     * Create a KitchenController and inject the inventorylist to it.
     */

    public KitchenController createKitchen(){
        return new KitchenController(this.inventoryList);
    }
}
