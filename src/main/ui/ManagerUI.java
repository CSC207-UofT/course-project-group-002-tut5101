package ui;

import constant.UIMessage;
import controller.ManagerController;
import use_case.DishList;
import use_case.InventoryList;

import java.util.Scanner;

public class ManagerUI {
    
    private static DishList dishList;
    
    public ManagerUI(DishList dishList) {
    }

    public static void main(String[] args) {
        System.out.println(UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.MANAGER_ACTIONS);
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        ManagerController controller = new ManagerController();
        switch (action) {
            // Assign serving staff to table
            case 1:
                String staffID = scanner.next();
                controller.assignStaffToTable(staffID);
                break;

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
                controller.deleteReview();
                break;

        }
    }
}
