package presenter.inventory_system;

import presenter.inventory_system.view_interfaces.CheckInventoryInterface;
import use_case.inventory.InventoryList;

/**
 * Controls the process for check one existing inventory.
 */
public class CheckInventoryPresenter {
    private CheckInventoryInterface checkInventoryInterface;
    private final InventoryList inventories;
    /**
     * Constructor for this class
     */
    public CheckInventoryPresenter(){
        this.inventories = new InventoryList();
    }

    /**
     * Set the view interface
     * @param checkInventoryInterface the view interface
     */

    public void setCheckInventoryInterface(CheckInventoryInterface checkInventoryInterface) {
        this.checkInventoryInterface = checkInventoryInterface;
    }
    /**
     * Return the information of the item
     * @param name the name of the item
     */

    private String getInfo(String name){
        if(this.inventories.checkExist(name)){
            return this.inventories.getInfo(name);}
        else{return "Invalid name";}
    }
    /**
     * Check whether the name is a valid name for an inventory item
     * @param name the nam eof the item
     */
    public void checkValidity(String name){
        String info = this.getInfo(name);
        this.checkInventoryInterface.CheckValidity(info);
    }
}
