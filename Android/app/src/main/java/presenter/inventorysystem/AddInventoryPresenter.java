package presenter.inventorysystem;

import use_case.inventory_system.InventoryFactory;
import use_case.kitchen_system.InventoryList;

public class AddInventoryPresenter {
    private AddinventoryViewInterface addinventoryViewInterface;
    private final InventoryList inventories;
    private final InventoryFactory infc = new InventoryFactory();

    public AddInventoryPresenter(){this.inventories = new InventoryList();}

    public AddInventoryPresenter(InventoryList inventories){
        this.inventories = inventories;
    }

    public void setAddInventoryViewInterface(AddinventoryViewInterface addinventoryViewInterface) {
        this.addinventoryViewInterface = addinventoryViewInterface;
    }

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
