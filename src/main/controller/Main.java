package controller;

import ui.LoginUI;
import constant.UserType;
import ui.ManagerUI;
import use_case.DishList;
import use_case.LoginUseCase;
import use_case.UserList;

public class Main {

    private static boolean login;
    private static String currentUserId;
    private static UserList userList;
    private static DishList dishList;

    /**
     * User Login
     */
    private static void userLogin() {
        // Create useCase in controller. Use case need to implement an interface.
        // initialize the controller in UI
        // initialize use case in the controller
        LoginUseCase loginUseCase = new LoginUseCase(userList);
        LoginController controller = new LoginController(loginUseCase);
        LoginUI ui = new LoginUI();
        String userId = ui.runLogin(controller);
        if (userId != null) {
            currentUserId = userId;
            login = true;
        }
    }

    public static void assignUser(){
        UserType userType = userList.getUserTypeById(currentUserId);
        switch(userType){
            // TODO pass to different controllers based on type
            case CUSTOMER:
                new CustomerUI(dishList);
                break;
            case MANAGER:
                new ManagerUI(dishList);
                break;
            case DELIVERY_STAFF:
                new DeliveryStaffUI();
                break;
            case INVENTORY_STAFF:
                new InventoryStaffUI();
                break;
            case SERVING_STAFF:
                new ServingStaffUI();
                break;
            case KITCHEN:
                new KitchenUI();
        }
    }

    public static void main(String[] args) {
        // TODO: Load data (userList/dishList) from file to the program

        // User Login
        while (!login) {
            userLogin();
        }
        assignUser();


    }

}

