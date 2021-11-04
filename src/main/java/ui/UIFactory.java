package ui;

import constant.*;

public class UIFactory {

    private CustomerUI customerUI = new CustomerUI();
    private ManagerUI managerUI = new ManagerUI();
    private DeliveryStaffUI deliveryStaffUI = new DeliveryStaffUI();
    private InventoryUI inventoryStaffUI = new InventoryUI();
    private ServingStaffUI servingStaffUI = new ServingStaffUI();
    private KitchenUI kitchenUI = new KitchenUI();
    private LoginUI loginUI = new LoginUI();
    private String id;

    public UIFactory(String id){
        this.id = id;
    }

    public void loadUI(UserType userType) {
        switch (userType) {
            case CUSTOMER:
                customerUI.loadUi(id);
                break;
            case MANAGER:
                managerUI.loadUi(id);
                break;
            case DELIVERY_STAFF:
                deliveryStaffUI.loadUi(id);
                break;
            case INVENTORY_STAFF:
                inventoryStaffUI.loadUi(id);
                break;
            case SERVING_STAFF:
                servingStaffUI.loadUi(id);
                break;
            case KITCHEN:
                kitchenUI.loadUi(id);
                break;
            default:
                loginUI.loadUi("");
        }
    }

}
