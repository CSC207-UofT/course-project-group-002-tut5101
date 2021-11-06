package ui;

import constant.UIMessage;
import controller.ManagerController;
import use_case.ReviewList;

import java.util.Scanner;

public class ManagerUI implements UserInterface {

    private boolean logIn;

    public ManagerUI() {
        this.logIn = true;
    }

    @Override
    public void loadUi(String managerId) {
        while (logIn) {
            System.out.println(UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.MANAGER_ACTIONS);
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextInt();
            ManagerController controller = new ManagerController();
            switch (action) {

                // Manage menu
                case 1:
                    controller.manageMenu();
                    break;


                // Delete Review
                case 2:
                    controller.deleteReview();
                    break;

                // logout
                case 0:
                    logIn = false;
                    break;
            }
        }
    }
}
