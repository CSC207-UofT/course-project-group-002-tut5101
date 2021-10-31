package ui;

import constant.UIMessage;
import controller.ManagerController;
import use_case.DishList;
import use_case.InventoryList;

import java.util.Scanner;

public class ManagerUI implements UserInterface{
    
    private static DishList dishList;
    
    public ManagerUI(DishList dishList) {
        this.dishList = dishList;
    }

    @Override
    public String loadUi(String managerId) {
        System.out.println(UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.MANAGER_ACTIONS);
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        ManagerController controller = new ManagerController();
        // interface for q3.
        switch (action) {

            // Manage menu
            case 2:
                controller.manageMenu(dishList);
                break;

            // Request inventory
            case 3:
                InventoryList inventoryList = null;
                controller.requestInventory(inventoryList);
                break;

            // Delete Review
            case 4:
                ReviewList reviewList = null;
                controller.deleteReview(reviewList);
                break;

        }
        return "";
    }
}
