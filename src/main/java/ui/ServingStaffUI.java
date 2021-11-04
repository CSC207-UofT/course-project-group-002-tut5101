package ui;
import constant.*;
import java.util.*;
import controller.StaffController;

public class ServingStaffUI implements UserInterface {
    StaffController currentServingStaff;

    public ServingStaffUI() {
        currentServingStaff = new StaffController();
    }

    /**
     * Run the user interface for Serving staff, when calling run, make sure you have the user's id.
     * @param id The id of the current user.
     */
    public void loadUi (String id) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(StaffUIMessage.GREETING_ASK_FOR_ACTION + StaffUIMessage.SERVING_STAFF_ACTIONS);
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    // Case 0: logout
                    System.out.println(LoginLogoutUIMessage.LOGOUT_SUCCESSFUL);
                    return;
                case 1:
                    // Case 1: view current Dish
                    try {
                        System.out.println(currentServingStaff.displayCurrent(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    // Case 2: get next Dish
                    try {
                        currentServingStaff.getNext(id);
                        System.out.println(currentServingStaff.displayCurrent(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Case 3: mark current as delivered
                    try {
                        currentServingStaff.completeCurrent(id);
                        System.out.println(StaffUIMessage.DISH_MARKED_COMPLETED);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}