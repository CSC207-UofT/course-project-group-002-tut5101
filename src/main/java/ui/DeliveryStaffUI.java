package ui;

import constant.StaffUIMessage;
import constant.LoginLogoutUIMessage;
import controller.StaffController;

import java.util.Scanner;
/**
 * UI class for delivery staff.
 */


public class DeliveryStaffUI implements UserInterface {
    StaffController currentDeliveryStaff;

    public DeliveryStaffUI() {
        currentDeliveryStaff = new StaffController();
    }

    /**
     * Run the user interface for Delivery staff, when calling run, make sure you have the user's id.
     * @param id The id of the current user.
     */
    public void loadUi (String id) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(StaffUIMessage.GREETING_ASK_FOR_ACTION + StaffUIMessage.DELIVERY_STAFF_ACTIONS);
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    // Case 0: logout
                    System.out.println(LoginLogoutUIMessage.LOGOUT_SUCCESSFUL);
                    return;
                case 1:
                    // Case 1: view current order
                    try {
                        System.out.println(currentDeliveryStaff.displayCurrent(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    // Case 2: get next order
                    try {
                        currentDeliveryStaff.getNext(id);
                        System.out.println(currentDeliveryStaff.displayCurrent(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Case 3: mark current as delivered
                    try {
                        currentDeliveryStaff.completeCurrent(id);
                        System.out.println(StaffUIMessage.ORDER_MARKED_COMPLETED);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }

}