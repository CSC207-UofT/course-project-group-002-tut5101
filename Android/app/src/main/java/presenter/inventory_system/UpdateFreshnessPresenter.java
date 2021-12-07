package presenter.inventory_system;

import presenter.inventory_system.view_interfaces.UpdateFreshnessInterface;
import use_case.inventory.InventoryList;
/**
 * Presenter class for the UpdateFreshness activity that change the freshness of an inventory item
 */

public class UpdateFreshnessPresenter {

    private UpdateFreshnessInterface updateFreshnessInterface;
    private final InventoryList inventories;
    /**
     * Constructor for this class
     */
    public UpdateFreshnessPresenter(){
        this.inventories = new InventoryList();
    }

    /**
     * Set the view interface
     * @param updateFreshnessInterface the view interface
     */
    public void setUpdateFreshnessInterface(UpdateFreshnessInterface updateFreshnessInterface) {
        this.updateFreshnessInterface = updateFreshnessInterface;
    }
    /**
     * Change the freshness of an item and return the information of this action
     * @param name the name of the item
     * @param newFreshness the new freshness of the item
     */

    private String newFreshness(String name, String newFreshness){
        String message;
        if(this.inventories.isHasFreshness(name)){
            this.inventories.setFreshness(name, newFreshness);
            message = "updated";
        }
        else{message = "item does not have freshness";}
        return message;
    }
    /**
     * Show the information of the action of changing freshness
     * @param name the name of the item
     * @param newFreshness the new freshness of the item
     */
    public void popInfo(String name, String newFreshness){
        String message = this.newFreshness(name, newFreshness);
        this.updateFreshnessInterface.popInfo(message);
    }


}
