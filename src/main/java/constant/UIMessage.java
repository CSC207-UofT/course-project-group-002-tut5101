package constant;

/**
 * This class holds all the UI messages in the program
 */
public class UIMessage {
    public static final String MENU_TITLE = "~~~~~~~~~~~~~~~~~~~ M E N U ~~~~~~~~~~~~~~~~~~~~~";
    public static final String ASK_FOR_ID = "Please enter your id: ";
    public static final String ASK_FOR_PASSWORD = "Please enter your password: ";

    public static final String LOGIN_FAILED = "Login Failed. Please ask for assistance.";
    public static final String ASK_FOR_SIGNUP = "Do you want to sign up？";
    public static final String GREETING_ASK_FOR_ACTION= "Welcome!\nPlease enter number of the action listed below: \n";

    // CUSTOMER_ACTIONS now in constants.CustomerUIMessage
    // public static final String CUSTOMER_ACTIONS = "1. Place Order\n 2. Ask for assistance\n 3. Pay bill\n " +
    //        "4. Leave a review\n 0. Logout";;
    public static final String SERVING_STAFF_ACTIONS = "1. View dish to be served\n 2. Mark dish as served\n 0. Logout";
    public static final String DELIVERY_STAFF_ACTIONS = "1. View order to be delivered\n 2. Mark dish as delivered\n 0. Logout";
    public static final String MANAGER_ACTIONS = "1. View uncompleted orders\n 0. Logout";
    public static final String ASK_FOR_DISH_NUMBER = "Please enter the dish number you want to order " +
            "(separate by a enter and ends by 'e'):";

}
