package ui;

import constant.UserType;

public class UIFactory {

    public static UserInterface getUI(UserType userType){
        switch (userType){
            case CUSTOMER:
                return new CustomerUI(dishList);
            case MANAGER:
                return new ManagerUI(dishList);
            case DELIVERY_STAFF:
                returnDeliveryStaffUI();
            case INVENTORY_STAFF:
                returnInventoryStaffUI();
            case SERVING_STAFF:
                return ServingStaffUI();
            case KITCHEN:
                return KitchenUI();
            default:
                return null;
        }
    }

}
