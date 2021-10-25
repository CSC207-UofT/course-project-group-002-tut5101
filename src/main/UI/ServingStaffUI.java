package UI;
import boundary.ServingStaffControllerInterface;
import constant.*;
import java.util.*;
import controller.ServingStaffController;

public class ServingStaffUI {
    ServingStaffControllerInterface currentServingStaff;

    public void ServingStaffUI(String id) {
        currentServingStaff = (ServingStaffControllerInterface) new ServingStaffController(id);
    }

    public void run () {
        boolean login = true;
        while (login) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.SERVING_STAFF_ACTIONS);
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    login = false;
                    break;
                case 1:
                    try {
                        currentServingStaff.getServeDish();
                        System.out.println("Table: " + currentServingStaff.getTableNumber() +
                                " Dish: " + currentServingStaff.getDishName() + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        currentServingStaff.completeDish();
                        System.out.println("Dish marked as completed\n");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
            }
        }
    }
}
