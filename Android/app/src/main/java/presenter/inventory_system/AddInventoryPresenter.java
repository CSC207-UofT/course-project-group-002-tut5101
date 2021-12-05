package presenter.inventory_system;

import use_case.inventory_factory.InventoryFactory;
import use_case.kitchen.InventoryList;
/**
 * Controls the process for adding new inventory.
 */
public class AddInventoryPresenter {
    private AddinventoryViewInterface addinventoryViewInterface;
    private final InventoryList inventories;
    private final InventoryFactory infc = new InventoryFactory();
    /**
     * Constructor for this class
     */

    public AddInventoryPresenter(){this.inventories = new InventoryList();}

    public AddInventoryPresenter(InventoryList inventories){
        this.inventories = inventories;
    }
    /**
     * Set the view interface
     * @param addinventoryViewInterface the view interface
     */
    public void setAddInventoryViewInterface(AddinventoryViewInterface addinventoryViewInterface) {
        this.addinventoryViewInterface = addinventoryViewInterface;
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
        String message = this.inventories.addFromFactory(this.infc, paras);
        this.addinventoryViewInterface.updateInventoryList(message);
    }
}
