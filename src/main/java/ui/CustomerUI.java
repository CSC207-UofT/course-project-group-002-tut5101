package ui;

import constant.CustomerUIMessage;
import controller.MenuController;
import controller.OrderController;
import controller.ReviewController;


import java.util.*;
import java.util.List;

public class CustomerUI implements UserInterface{
    /**
     * CMD UI for Users that login as Customer
     */

    private final OrderController orderController;
    private final MenuController menuController;
    private final ReviewController reviewController;
    private boolean logIn;

    public CustomerUI() {
        this.orderController = new OrderController();
        this.menuController = new MenuController();
        this.reviewController = new ReviewController();
        this.logIn = true;
    }


    @Override
    public void loadUi(String id) {
        while (logIn) {
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

                    printMenu();

                    ArrayList<Integer> orderedNum;
                    orderedNum = orderedDishesUI();

                    List<String> dishes = dishNamesOrdered(orderedNum);

                    String[] dishesAsList = dishes.toArray(new String[0]);

                    System.out.println(CustomerUIMessage.CONFIRM_ORDER);
                    System.out.println(dishes.toString());
                    String confirm = scanner.nextLine();
                    if (confirm.equals("Y")) {
                        runPlaceOrder(orderController, dineInStatus, dishesAsList, location);
                    }
                    System.out.println(CustomerUIMessage.ORDER_PLACED);
                    break;

                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    String complaint;
                    boolean ifAnonymous;
                    boolean ifComplain;
                    ifAnonymous = ifAnonymousUI();
                    System.out.println(CustomerUIMessage.ASK_FOR_RATE);
                    int rate = scanner.nextInt();
                    String rn = scanner.nextLine();
                    System.out.println(CustomerUIMessage.ASK_FOR_COMMENT);
                    String comment = scanner.nextLine();
                    ifComplain = ifComplainUI();
                    if(ifComplain){
                        System.out.println(CustomerUIMessage.ASK_COMPLAIN_INFO);
                        complaint = scanner.nextLine();
                    } else {
                        complaint = "no complaint";
                    }
                    reviewController.addToReviewList(id, ifAnonymous, rate, comment, ifComplain, complaint);
                    reviewController.saveToFile();
                    System.out.println(CustomerUIMessage.SHOW_REVIEW);
                    break;
                case "0":
                    logIn = false;
                    break;
                default:
                    break;
            }
        }
    }

    // TODO: Write helper to print menu
    public void printMenu(){
        System.out.println(CustomerUIMessage.MENU_TITLE);
        System.out.println(menuController.dishesInMenuAsString());
    }

    public List<String> dishNamesOrdered(List<Integer> orderedNum){
        List<String> dishes;
        dishes = menuController.passDishNumbersOrdered(orderedNum);
        return dishes;
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

    public boolean ifAnonymousUI() {
        while (true) {
            System.out.println(CustomerUIMessage.ASK_IF_ANONYMOUS);
            Scanner scanner = new Scanner(System.in);
            String ifAnonymous = scanner.nextLine();
            switch (ifAnonymous) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Please enter a valid input.");
            }

        }
    }

    public boolean ifComplainUI() {
        while (true) {
            System.out.println(CustomerUIMessage.ASK_IF_COMPLAIN_STUFF);
            Scanner scanner = new Scanner(System.in);
            String ifComplain = scanner.nextLine();
            switch (ifComplain) {
                case "Y":
                    return true;
                case "N":
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

    private ArrayList<Integer> orderedDishesUI(){
        System.out.println(CustomerUIMessage.PLACE_ORDER);
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> orderedNum = new ArrayList<Integer>();
        while (scanner.hasNextInt()){
            orderedNum.add(scanner.nextInt());
        }
//        while (!scanner.next().equals("e")){
//            dishes.add(scanner.next());
//        }
        return orderedNum;
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