package presenter.inventorysystem;

import use_case.boundary.output.InventoryOutputBoundary;
import use_case.kitchen.InventoryList;

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

    public void showInfo(String name, String usage, InventoryOutputBoundary boundary){
        String message = this.newQuantity(name, usage, boundary);
        this.updateQuanInterface.popInfo(message);
    }
}
