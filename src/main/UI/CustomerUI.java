package UI;

import constant.CustomerUIMessage;
import controller.OrderController;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerUI {
    /**
     * CMD UI for Users that login as Customer
     */

    private final OrderController orderController;

    public CustomerUI() {
        this.orderController = new OrderController();
    }


    public String runCustomerActions() {
        while (true) {
            System.out.println(CustomerUIMessage.CUSTOMER_ACTIONS);
            System.out.println(CustomerUIMessage.SELECT_ACTION);
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    boolean dineInStatus = orderTypeUI();

                    /**
                     * Print the menu and then use helper method to get input for what dishes, then pass to the
                     * place order controller
                     */
                    String location = locationUI(dineInStatus);

                    String[] dishes;
                    dishes = orderedDishesUI().toArray(new String[0]);

                    System.out.println(CustomerUIMessage.CONFIRM_ORDER);
                    System.out.println(dishes.toString());
                    String confirm = scanner.nextLine();
                    if (confirm.equals('Y')) {
                       runPlaceOrder(orderController, dineInStatus, dishes, location);
                    }
                    System.out.println(CustomerUIMessage.ORDER_PLACED);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    break;
                default:
                    return null;
            }
        }
    }

    // TODO: Write helper to print menu
    public void printMenu(){
        System.out.println(CustomerUIMessage.MENU_TITLE);
        // TODO: print the menu
    }

    public boolean orderTypeUI() {
        while (true) {
            System.out.println(CustomerUIMessage.SELECT_ORDER_TYPE);
            Scanner scanner = new Scanner(System.in);
            String type = scanner.nextLine();
            switch (type) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Please enter a valid input.");
            }

        }
    }

    /**
     * Cmd UI of place order.
     *
     * @return the list of dish names customer ordered
     */

    private ArrayList<String> orderedDishesUI(){
        System.out.println(CustomerUIMessage.PLACE_ORDER);
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dishes = new ArrayList();
        while (!scanner.next().equals('e')){
            dishes.add(scanner.next());
        }
        return dishes;
    }

    private String locationUI(boolean dineInStatus){
        Scanner scanner = new Scanner(System.in);
        String location;
        if (dineInStatus){
            System.out.println(CustomerUIMessage.ENTER_TABLE_NUMBER);
        }
        else {
            System.out.println(CustomerUIMessage.ENTER_LOCATION);
        }
        location = scanner.nextLine();
        return location;
    }

    // TODO: Finish this method (note it needs to catch exception)
    private void runPlaceOrder(OrderController controller, boolean dineIn, String[] dishes, String location) {
        try {
            controller.runPlaceOrder(dineIn, dishes, location);
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }

}
