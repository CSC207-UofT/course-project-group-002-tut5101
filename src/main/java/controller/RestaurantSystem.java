package controller;

import constant.UserType;
import ui.LoginUI;
import ui.UIFactory;

public class RestaurantSystem {

    private boolean login;
    private String currentUserId;

    private final LoginController loginController = new LoginController();


    /**
     * User Login
     */
    private void userLogin() {

        LoginUI ui = new LoginUI();
        String userId = ui.loadUi();

        if (userId != null) {
            currentUserId = userId;
            login = true;

        }
    }

    public void UILoader(){
        UserType userType = loginController.getUserTypeById(currentUserId);
        UIFactory factory = new UIFactory(currentUserId);
        factory.loadUI(userType);
    }

    public void run(){
        // User Login
        while (!login) {
            userLogin();
        }
        UILoader();
    }
}