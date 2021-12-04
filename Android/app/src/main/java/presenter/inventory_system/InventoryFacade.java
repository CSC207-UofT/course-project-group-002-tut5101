package presenter.inventory_system;

import use_case.kitchen.InventoryList;
/**
 * The Facade used to create presenters in inventory_system
 */
public class InventoryFacade {
    InventoryList inventories;
    /**
     * Create a AddInventoryPresenter and inject the inventorylist to it.
     */
    public AddInventoryPresenter createAddPresenter(){
        return new AddInventoryPresenter(this.inventories);
    }
    /**
     * Create a CheckInventoryPresenter and inject the inventorylist to it.
     */
    public CheckInventoryPresenter createCheckPresenter(){
        return new CheckInventoryPresenter(this.inventories);
    }
    /**
     * Create a UpdateQuanPresenter and inject the inventorylist to it.
     */
    public UpdateQuantityPresenter createQuanPresenter(){
        return new UpdateQuantityPresenter(this.inventories);
    }
    /**
     * Create a UpdateFreshnessPresenter and inject the inventorylist to it.
     */
    public UpdateFreshnessPresenter updateFreshnessPresenter(){
        return new UpdateFreshnessPresenter(this.inventories);
    }

}
