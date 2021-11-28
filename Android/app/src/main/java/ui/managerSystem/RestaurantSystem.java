package ui.managerSystem;

import constant.mangerSystem.UserType;
import controller.loginSystem.LoginController;
import presenter.LoginPresenter;
import ui.UIFactory;
import ui.loginPrompt.LoginUI;

public class RestaurantSystem {

    private boolean login;
    private String currentUserId;

    private final LoginController loginController = new LoginController();

    public RestaurantSystem() {
        LoginPresenter loginPresenter = new LoginPresenter();
        loginController.createUseCaseInteractor(loginPresenter);
    }

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