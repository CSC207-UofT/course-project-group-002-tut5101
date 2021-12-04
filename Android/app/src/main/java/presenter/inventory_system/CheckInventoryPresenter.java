package presenter.inventory_system;

import use_case.kitchen.InventoryList;

public class CheckInventoryPresenter {
    private CheckInventoryInterface checkInventoryInterface;
    private final InventoryList inventories;

    public CheckInventoryPresenter(){
        this.inventories = new InventoryList();
    }

    public CheckInventoryPresenter(InventoryList inventories){
        this.inventories = inventories;
    }

    public void setCheckInventoryInterface(CheckInventoryInterface checkInventoryInterface) {
        this.checkInventoryInterface = checkInventoryInterface;
    }

    private String getInfo(String name){
        if(this.inventories.checkExist(name)){
            return this.inventories.getInfo(name);}
        else{return "Invalid name";}
    }

    public void checkValidity(String name){
        String info = this.getInfo(name);
        this.checkInventoryInterface.CheckValidity(info);
    }
}
