package presenter.inventory_system;

import use_case.kitchen.InventoryList;

public class InventoryFacade {
    InventoryList inventories;

    public AddInventoryPresenter createAddPresenter(){
        return new AddInventoryPresenter(this.inventories);
    }

    public CheckInventoryPresenter createCheckPresenter(){
        return new CheckInventoryPresenter(this.inventories);
    }

    public UpdateQuantityPresenter createQuanPresenter(){
        return new UpdateQuantityPresenter(this.inventories);
    }

    public UpdateFreshnessPresenter updateFreshnessPresenter(){
        return new UpdateFreshnessPresenter(this.inventories);
    }

}
