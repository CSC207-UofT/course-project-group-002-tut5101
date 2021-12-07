package presenter.inventory_system;

import presenter.inventory_system.view_interfaces.UpdateQuantityInterface;
import use_case.inventory.boundary.InventoryOutputBoundary;
import use_case.inventory.InventoryList;

/**
 * Presenter class for the UpdateFreshness activity that change the freshness of an inventory item
 */

public class UpdateQuantityPresenter implements InventoryOutputBoundary{
    private UpdateQuantityInterface updateQuantityInterface;
    private final InventoryList inventories;
    /**
     * Constructor for this class
     */
    public UpdateQuantityPresenter(){
        this.inventories = new InventoryList();
    }
    /**
     * Set the view interface
     * @param updateQuantityInterface the view interface
     */

    public void setUpdateQuantityInterface(UpdateQuantityInterface updateQuantityInterface) {
        this.updateQuantityInterface = updateQuantityInterface;
    }
    /**
     * Pass the message through interface
     * @param message the message to send
     */
    @Override
    public String getMessage(String message){
        return message;
    }
    /**
     * Change the quantity of an item and return the information of this action
     * @param name the name of the item
     * @param usage the new usage of the item
     * @param boundary the output boundary
     */

    private String newQuantity(String name, String usage, InventoryOutputBoundary boundary){
        this.inventories.setBoundary(boundary);
        int u = Integer.parseInt(usage);
        return inventories.passNewQuantityInfo(name, u);
    }
    /**
     * Show the information of this action
     * @param name the name of the item
     * @param usage the new usage of the item
     */
    public void showInfo(String name, String usage){
        String message = this.newQuantity(name, usage, this);
        this.updateQuantityInterface.popInfo(message);
    }
}
