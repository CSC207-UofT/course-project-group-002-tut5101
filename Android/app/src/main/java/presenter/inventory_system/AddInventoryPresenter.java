package presenter.inventory_system;

import presenter.inventory_system.view_interfaces.AddInventoryViewInterface;
import use_case.inventory.InventoryFactory;
import use_case.inventory.InventoryList;

/**
 * Controls the process for adding new inventory.
 */
public class AddInventoryPresenter {
    private AddInventoryViewInterface addInventoryViewInterface;
    private final InventoryFactory inventory = new InventoryFactory();
    private final InventoryList inventoryList = new InventoryList();



    /**
     * Set the view interface
     * @param addInventoryViewInterface the view interface
     */
    public void setAddInventoryViewInterface(AddInventoryViewInterface addInventoryViewInterface) {
        this.addInventoryViewInterface = addInventoryViewInterface;
    }
    /**
     * Add a new Inventory item
     * @param name the name of the item
     * @param price the price of the item
     * @param amount the amount of the item
     * @param date the import date or the expiry date of the item
     * @param freshness the freshness for item has this feature, N/A for one do not have
     */

    public void addNewInventory(String name, String price, String amount, String date, String freshness){
        String para;
        if(freshness.equals("N/A")){
            para = name+","+price+","+amount+","+date;
        }
        else{para = name+","+price+","+amount+","+freshness+","+date;}
        String[] paras = para.split(",");
        String message = this.inventoryList.addFromFactory(this.inventory, paras);
        this.addInventoryViewInterface.updateInventoryList(message);
    }
}
