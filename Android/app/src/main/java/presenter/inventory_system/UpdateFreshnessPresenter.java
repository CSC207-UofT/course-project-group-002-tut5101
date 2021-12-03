package presenter.inventory_system;

import use_case.kitchen.InventoryList;

public class UpdateFreshnessPresenter {
    private UpdateFreshnessInterface updateFreshnessInterface;
    private final InventoryList inventories;
    public UpdateFreshnessPresenter(){
        this.inventories = new InventoryList();
    }
    public UpdateFreshnessPresenter(InventoryList inventories){
        this.inventories = inventories;
    }

    public void setUpdateFreshnessInterface(UpdateFreshnessInterface updateFreshnessInterface) {
        this.updateFreshnessInterface = updateFreshnessInterface;
    }


    private String newFreshness(String name, String newFreshness){
        String message;
        if(this.inventories.isHasFreshness(name)){
            this.inventories.setFreshness(name, newFreshness);
            message = "updated";
        }
        else{message = "item does not have freshness";}
        return message;
    }

    public void popInfo(String name, String newFreshness){
        String message = this.newFreshness(name, newFreshness);
        this.updateFreshnessInterface.popInfo(message);
    }


}
