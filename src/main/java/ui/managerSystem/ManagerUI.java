package ui.managerSystem;

import constant.uiMessage.ManagerUIMessage;
import controller.managerSystem.ManagerController;
import ui.UserInterface;

import java.util.Scanner;
/**
 * UI class for manager.
 */


public class ManagerUI implements UserInterface {

    private boolean logIn;

    public ManagerUI() {
        this.logIn = true;
    }

    @Override
    public void loadUi(String managerId) {
        while (logIn) {
            System.out.println(ManagerUIMessage.GREETING_ASK_FOR_ACTION + ManagerUIMessage.MANAGER_ACTIONS);
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextInt();
            ManagerController controller = new ManagerController();
            switch (action) {

                // Manage menu
                case 1:
                    controller.manageMenu();
                    System.out.println("Hello Sir, menu successfully adjusted.");
                    break;


                // Delete Review
                case 2:
                    controller.deleteReview();
                    System.out.println("Hello Sir, inadequate reviews are deleted.");
                    break;

                // logout
                case 0:
                    logIn = false;
                    break;
            }
        }
    }
}
