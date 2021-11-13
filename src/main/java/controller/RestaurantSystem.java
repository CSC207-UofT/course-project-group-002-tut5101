package controller;

import constant.UserType;
import ui.LoginUI;
import ui.UIFactory;
import use_case.DishList;
import use_case.UserList;

public class RestaurantSystem {

    private boolean login;
    private String currentUserId;
    private UserList userList;
    private DishList dishList;


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
        UserType userType = userList.getUserTypeById(currentUserId);
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