package ui;

import constant.mangerSystem.UserType;
import ui.customerSystem.CustomerUI;
import ui.managerSystem.ManagerUI;
import ui.deliverOrderSystem.DeliveryStaffUI;
import ui.inventorySystem.InventoryUI;
import ui.kitchenSystem.KitchenUI;
import ui.serveDishSystem.ServingStaffUI;
import ui.loginPrompt.LoginUI;
/**
 * UI factory for simple factory design pattern.
 */


public class UIFactory {

    private final CustomerUI customerUI = new CustomerUI();
    private final ManagerUI managerUI = new ManagerUI();
    private final DeliveryStaffUI deliveryStaffUI = new DeliveryStaffUI();
    private final InventoryUI inventoryStaffUI = new InventoryUI();
    private final ServingStaffUI servingStaffUI = new ServingStaffUI();
    private final KitchenUI kitchenUI = new KitchenUI();
    private final LoginUI loginUI = new LoginUI();
    private final String id;

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
                loginUI.loadUi();
        }
    }

}
