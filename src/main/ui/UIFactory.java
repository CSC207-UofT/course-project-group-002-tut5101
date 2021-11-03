package ui;

import constant.UserType;

public class UIFactory {

    private CustomerUI customerUI = new CustomerUI();
    private ManagerUI managerUI = new ManagerUI();
    private DeliveryStaffUI deliveryStaffUI = new DeliveryStaffUI();
    private InventoryStaffUI InventoryStaffUI = new InventoryStaffUI();
    private ServingStaffUI servingStaffUI = new ServingStaffUI();
    private KitchenUI kitchenUI = new KitchenUI();
    private LoginUI loginUI = new LoginUI();
    private String id;

    public UIFactory(String id){
        this.id = id;
    }

    public UserInterface loadUI(UserType userType) {
        switch (userType) {
            case CUSTOMER:
                customerUI.loadUi(id);
                break;
            case MANAGER:
                managerUI.loadUi(id);
                break;
            case DELIVERY_STAFF:
                deliveryStaffUI.loadUi();
                break;
            case INVENTORY_STAFF:
                inventoryStaffUI.loadUi();
                break;
            case SERVING_STAFF:
                servingStaffUI.loadUi();
                break;
            case KITCHEN:
                kitchenUI.loadUi();
                break;
            default:
                loginUI.loadUi("");
        }
    }

}
