package presenter.inventory_system;

import com.example.androidgui.inventory_activities.UpdateQuantityActivity;
import constant.file_system.FileName;
import use_case.inventory_factory.InventoryOutputBoundary;
import use_case.kitchen.InventoryList;
//TODO: issues here with showInfo message, not MVP!
public class UpdateQuantityPresenter {
    private UpdateQuantityInterface updateQuantityInterface;
    private final InventoryList inventories;
    public UpdateQuantityPresenter(){
        this.inventories = new InventoryList(FileName.INVENTORY_FILE);
    }
    public UpdateQuantityPresenter(InventoryList inventories){
        this.inventories = inventories;
    }
    public void setUpdateQuanInterface(UpdateQuantityInterface updateQuantityInterface) {
        this.updateQuantityInterface = updateQuantityInterface;
    }

    private String newQuantity(String name, String usage, InventoryOutputBoundary boundary){
        this.inventories.setBoundary(boundary);
        int u = Integer.parseInt(usage);
        return inventories.setQuantity(name, u);
    }

    public void showInfo(String name, String usage, UpdateQuantityActivity boundary){
        String message = this.newQuantity(name, usage, boundary);
        this.updateQuantityInterface.popInfo(message);
    }
}
