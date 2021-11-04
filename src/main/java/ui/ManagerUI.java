package ui;

import constant.UIMessage;
import controller.ManagerController;
import use_case.ReviewList;

import java.util.Scanner;

public class ManagerUI implements UserInterface {


    @Override
    public void loadUi(String managerId) {
        System.out.println(UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.MANAGER_ACTIONS);
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        ManagerController controller = new ManagerController();
        // interface for q3.
        switch (action) {

            // Manage menu
            case 2:
                controller.manageMenu();
                break;


            // Delete Review
            case 4:
                ReviewList reviewList = null;
                controller.deleteReview(reviewList);
                break;

        }
    }
}
