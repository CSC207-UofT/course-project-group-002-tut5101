package presenter.inventorysystem;

import use_case.kitchen.InventoryList;

public class InventoryFacade {
    InventoryList inventories;

    public AddInventoryPresenter createAddPresenter(){
        AddInventoryPresenter addInventoryPresenter = new AddInventoryPresenter(this.inventories);
        return addInventoryPresenter;
    }

    public CheckInventoryPresenter createCheckPresenter(){
        CheckInventoryPresenter checkInventoryPresenter = new CheckInventoryPresenter(this.inventories);
        return checkInventoryPresenter;
    }

    public UpdateQuanPresenter createQuanPresenter(){
        UpdateQuanPresenter updateQuanPresenter = new UpdateQuanPresenter(this.inventories);
        return updateQuanPresenter;
    }

    public UpdateFreshnessPresenter updateFreshnessPresenter(){
        UpdateFreshnessPresenter updateFreshnessPresenter = new UpdateFreshnessPresenter(this.inventories);
        return updateFreshnessPresenter;
    }

}
