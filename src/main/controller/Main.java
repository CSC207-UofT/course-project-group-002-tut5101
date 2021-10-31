package controller;

import ui.LoginUI;
import constant.UserType;
import ui.ManagerUI;
import ui.UIFactory;
import ui.UserInterface;
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
        UserInterface ui = UIFactory.getUI(userType);
        ui.loadUi();
    }

    public static void main(String[] args) {

        // 1. init load data
        // 2. login LoginManager man  = new
        // man.userLogin();
        // 3. switch to different ui -> controller => use case -> ui







        // TODO: Load data (userList/dishList) from file to the program

        // User Login
        while (!login) {
            userLogin();
        }
        assignUser();




    }

}

