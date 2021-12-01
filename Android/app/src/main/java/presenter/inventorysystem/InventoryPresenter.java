package presenter.inventorysystem;

public class InventoryPresenter {
    private UpdateFreshnessInterface updateFreshnessInterface;
    private UpdateQuanInterface updateQuanInterface;
    private CheckInventoryInterface checkInventoryInterface;
    private AddinventoryViewInterface addinventoryViewInterface;


    public void setAddInventoryViewInterface(AddinventoryViewInterface addinventoryViewInterface) {
        this.addinventoryViewInterface = addinventoryViewInterface;
    }

    public void setCheckInventoryInterface(CheckInventoryInterface checkInventoryInterface) {
        this.checkInventoryInterface = checkInventoryInterface;
    }

    public void setUpdateFreshnessInterface(UpdateFreshnessInterface updateFreshnessInterface) {
        this.updateFreshnessInterface = updateFreshnessInterface;
    }

    public void setUpdateQuanInterface(UpdateQuanInterface updateQuanInterface) {
        this.updateQuanInterface = updateQuanInterface;
    }

    public void popInfo(String message){
        this.updateFreshnessInterface.popInfo(message);
    }

    public void showInfo(String message){
        this.updateQuanInterface.popInfo(message);
    }

    public void checkValidity(String info){
        this.checkInventoryInterface.Checkvalidity(info);
    }
}
