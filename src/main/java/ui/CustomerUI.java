package ui;

import constant.CustomerUIMessage;
import controller.MenuController;
import controller.OrderController;
import entity.Review;
import use_case.ReviewList;

import java.util.*;
import java.util.List;

public class CustomerUI implements UserInterface{
    /**
     * CMD UI for Users that login as Customer
     */

    private final OrderController orderController;
    private final MenuController menuController;
    private boolean logIn;

    public CustomerUI() {
        this.orderController = new OrderController();
        this.menuController = new MenuController();
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
                    String name;
                    String complaint;
                    boolean ifAnonymous;
                    boolean ifComplain;
                    ReviewList rl = new ReviewList();

                    System.out.println(CustomerUIMessage.ASK_IF_ANONYMOUS);
                    String anonymous = scanner.nextLine();
                    if(anonymous.equals("Y")){
                        name = "Anonymous";
                        ifAnonymous = true;
                    } else {
                        name = id;
                        ifAnonymous = false;
                    }
                    System.out.println(CustomerUIMessage.ASK_FOR_RATE);
                    int rate = scanner.nextInt();

                    System.out.println(CustomerUIMessage.ASK_FOR_COMMENT);
                    String comment = scanner.nextLine();

                    System.out.println(CustomerUIMessage.ASK_IF_COMPLAIN_STUFF);
                    String complain = scanner.nextLine();
                    if(complain.equals("Y")){
                        ifComplain = true;
                        System.out.println(CustomerUIMessage.ASK_COMPLAIN_INFO);
                        complaint = scanner.nextLine();
                    } else {
                        ifComplain = false;
                        complaint = "no complaint";
                    }
                    Review r = new Review(name, ifAnonymous, rate, comment, ifComplain, complaint);
                    rl.addReview(r);
                    rl.SavetoFile("src/main/resources/review.ser");
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