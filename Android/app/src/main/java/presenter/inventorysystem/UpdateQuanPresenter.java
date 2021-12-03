package presenter.inventorysystem;

import com.example.androidgui.inventoryactivities.UpdateQuanActivity;
import use_case.inventory_system.InventoryOutputBoundary;
import use_case.kitchen_system.InventoryList;

public class UpdateQuanPresenter {
    private UpdateQuanInterface updateQuanInterface;
    private final InventoryList inventories;
    public UpdateQuanPresenter(){
        this.inventories = new InventoryList();
    }
    public UpdateQuanPresenter(InventoryList inventories){
        this.inventories = inventories;
    }
    public void setUpdateQuanInterface(UpdateQuanInterface updateQuanInterface) {
        this.updateQuanInterface = updateQuanInterface;
    }

    private String newQuantity(String name, String usage, InventoryOutputBoundary boundary){
        this.inventories.setBoundary(boundary);
        int u = Integer.parseInt(usage);
        return inventories.setQuantity(name, u);
    }

    public void showInfo(String name, String usage, UpdateQuanActivity boundary){
        String message = this.newQuantity(name, usage, boundary);
        this.updateQuanInterface.popInfo(message);
    }
}
