package presenter.inventorysystem;

import use_case.inventory_system.InventoryFactory;
import use_case.kitchen_system.InventoryList;

public class CheckInventoryPresenter {
    private CheckInventoryInterface checkInventoryInterface;
    private final InventoryList inventories;
    private final InventoryFactory infc = new InventoryFactory();

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
        this.checkInventoryInterface.Checkvalidity(info);
    }
}
