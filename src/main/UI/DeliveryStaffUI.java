package UI;
/**
 * ServingStaffUI
 * A UI for delivery staff
 * Created by Dedong Xie
 * On 2021-10-31
 */

import constant.UIMessage;
import controller.StaffController;

import java.util.Scanner;

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
            System.out.println(UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.DELIVERY_STAFF_ACTIONS);
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    // Case 0: logout
                    System.out.println("You have successfully logged out");
                    return;
                case 1:
                    // Case 1: get next order
                    try {
                        currentDeliveryStaff.getNext(id);
                        System.out.println(currentDeliveryStaff.displayCurrent(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    // Case 2: mark current as delivered
                    try {
                        currentDeliveryStaff.completeCurrent(id);
                        System.out.println("Order marked as completed\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }

}
