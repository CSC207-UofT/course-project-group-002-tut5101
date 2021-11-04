package controller;


import constant.UserType;
import ui.LoginUI;
import ui.UIFactory;
import ui.UserInterface;
import use_case.DishList;
import use_case.LoginUseCase;
import use_case.UserList;

public class RestaurantSystem {

    private boolean login;
    private String currentUserId;
    private UserList userList;
    private DishList dishList;


    /**
     * User Login
     */
    private void userLogin() {

        LoginUI ui = new LoginUI();
        String userId = ui.loadUi(); //ui.runLogin(controller);


        if (userId != null) {
            currentUserId = userId;
            login = true;

        }
    }

    public void UILoader(){
        UserType userType = userList.getUserTypeById(currentUserId);
        UIFactory factory = new UIFactory(currentUserId);
        factory.loadUI(userType);
    }

    public void run(){

        // 1. init load data
        // 2. login LoginManager man  = new
        // man.userLogin();
        // 3. switch to different ui -> controller => use case -> ui







        // TODO: Load data (userList/dishList) from file to the program

        // User Login
        while (!login) {
            userLogin();
        }
        UILoader();





    }
}










//import java.util.*;
//
//import ui.LoginUI;
//import constant.UIMessage;


//import entity.*;
//import use_case.*;
//
//public class RestaurantSystem {
//
//    private static final UserList userList;
//    private static final List<Dish> menu;
//    private static boolean login;
//    private static String currentUserId;
//
//
//    static {
//        userList = generateUserList();
//        menu = generateDishList();
//    }
//
//
//    public static void main(String[] args) {
//        while (true) {
//            if(login){
//                // User has login
//                System.out.println("REACHING IF-ELSE LOGIN BLOCK");
//
//            }
//            else{
//                userLogin();
//            }
////            if (login) {
////                if (currentUser instanceof Customer) {
////
////                    int selectedAction = actionPicker(
////                            UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.CUSTOMER_ACTIONS, scanner);
////
////                    switch (selectedAction) {
////                        case 0:
////                            login = false;
////                            break;
////                        case 1:
////                            System.out.println(displayMenu());
////                            System.out.println(UIMessage.ASK_FOR_DISH_NUMBER);
////                            ArrayList<Integer> orderedNum = new ArrayList();
////                            while (scanner.hasNextInt()){
////                                orderedNum.add(scanner.nextInt());
////                            }
////                            double totalPrice = 0;
////                            for (int num : orderedNum) {
////                                System.out.println(menu.get(num - 1));
////                                totalPrice += menu.get(num - 1).getPrice();
////                            }
////                            System.out.print("Your total price for this order is $$" + totalPrice + " before" +
////                                    " tax. ☺\nPlease confirm your orders [y/n]:");
////                            scanner.next();
////                            String ans = scanner.next();
////                            if (ans.equals("y")) {
////                                List<Dish> orderedDishes = new ArrayList<Dish>();
////                                for (int num : orderedNum) {
////                                    orderedDishes.add(menu.get(num-1));
////                                }
////                                Order customerOrder = new Order(1, orderedDishes);
////                                System.out.println(customerOrder.toString());
////                                if (!PlacedOrderQueue.addOrder(customerOrder)) {
////                                    System.out.println("Your order cannot be placed\n\n");
////                                    break;
////                                }
////                                System.out.println("Your order has been placed, please wait...\n\n");
////                            }
////                            break;
////                        case 2:
////                            break;
////                        case 3:
////                            break;
////                    }
////                } else if (currentUser instanceof Manager) {
////                    actionPicker(
////                            UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.MANAGER_ACTIONS, scanner);
////                } else if (currentUser instanceof ServingStaff) {
////                    ServingStaff currentServingStaff = ((ServingStaff) currentUser);
////                    int action = actionPicker(
////                            UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.STAFF_ACTIONS, scanner);
////                    switch (action) {
////                        case 0:
////                            login = false;
////                            break;
////                        case 1:
////                            if (currentServingStaff.getServeDish()) {
////                                System.out.println("Table: " + currentServingStaff.getTableNum() +
////                                        " Dish: " + currentServingStaff.getDish().getName() + "\n");
////                            } else {
////                                System.out.println("Currently no dish to be served");
////                            }
////                            break;
////                        case 2:
////                            if (currentServingStaff.completeDish()) {
////                                System.out.println("Dish marked as completed\n");
////                            } else {
////                                System.out.println("You served air!\n");
////                            }
////                            break;
////                    }
////                } else if (currentUser == null) {
////                    System.out.println("You have login as the kitchen, enter number of action listed below:");
////                    StringBuilder actionList = new StringBuilder("1. View order to be cooked\n" +
////                            "2. Mark dish as cooked\n" +
////                            "0. Logout");
////                    int action = actionPicker(actionList.toString(), scanner);
////                    switch (action) {
////                        case 0:
////                            login = false;
////                            break;
////                        case 1:
////                            if (Kitchen.getNextToCook()) {
////                                System.out.println("Cooking " + Kitchen.getCurrentOrder().toString());
////                            } else {
////                                System.out.println("No order to be cooked");
////                            }
////                            break;
////                        case 2:
////                            actionList = new StringBuilder();
////                            List<Dish> dishList = Kitchen.getCurrentOrder().getDishes();
////                            for (int i = 1; i <= dishList.size(); i++) {
////                                actionList.append(i).append(" ").append(dishList.get(i-1).getName()).append("\n");
////                            }
////                            int dishToBeCooked = actionPicker(actionList.toString(), scanner);
////                            if (1 <= dishToBeCooked && dishToBeCooked <= dishList.size()) {
////                                Kitchen.cookedDish(dishList.get(dishToBeCooked-1));
////                                System.out.println("Dish marked as cooked.\n");
////                            } else {
////                                System.out.println("Invalid dish number: " + dishToBeCooked);
////                            }
////                            break;
////                    }
////                } else {
////                    login = false;
////                }
////            }
////            else {
////                userLoginHelper(scanner);
////            }
//        }
//    }
//
//    private static String displayMenu() {
//        StringBuilder menuString = new StringBuilder();
//        menuString.append(UIMessage.MENU_TITLE);
//        for (int i = 0; i < menu.size(); i++) {
//            menuString.append(i + 1).append(". ").append(menu.get(i).toString());
//        }
//        return menuString.toString();
//    }
//
//    public static int actionPicker(String actionList, Scanner scanner) {
//        System.out.println(actionList);
//        int selectedAction = scanner.nextInt();
//        login = (selectedAction != 0);
//        return selectedAction;
//    }
//
//    /**
//     * User Login
//     *
//     */
//    private static void userLogin(){
//        LoginUseCase loginUseCase = new LoginUseCase(userList);
//        LoginController controller = new LoginController(loginUseCase);
//        LoginUI ui = new LoginUI();
//        String userId = ui.runLogin(controller);
//        if(userId != null){
//            currentUserId = userId;
//            login = true;
//        }
//    }
//
////    /**
////     * Helper method of user login
////     *
////     * @param scanner System input
////     */
////    private static void userLoginHelper(Scanner scanner) {
////        System.out.print(UIMessage.ASK_FOR_ID);
////        String id = scanner.next();
////        if (Objects.equals(id, "0")) {
////            currentUser = null;
////            login = true;
////            return;
////        }
////        if (userList.getUsers().containsKey(id)) {
////            System.out.print(UIMessage.ASK_FOR_PASSWORD);
////            String password = scanner.next();
////            if (userList.getUsers().get(id).passwordMatches(password)) {
////                login = true;
////                currentUser = userList.getUsers().get(id);
////            } else {
////                System.out.println(UIMessage.LOGIN_FAILED);
////            }
////        } else {
////            System.out.println(UIMessage.ASK_FOR_SIGNUP);
////        }
////    }
//
//    /**
//     * Generate the UseCase.UserList
//     *
//     * @return a Hashmap mapping user ids to Users
//     */
//    public static UserList generateUserList() {
//        UserList userList = new UserList();
//        userList.add(new Manager());
//        userList.add(new Customer("2", "Howard", "12345"));
//        userList.add(new ServingStaff("8", "Tom", "12345", 4000));
//        return userList;
//    }
//
//    /**
//     * This method is used to generate a list of dishes that used to display to users
//     *
//     * @return a HashMap mapping dish name and the dish
//     */
//    public static ArrayList<Dish> generateDishList() {
//        ArrayList<Dish> dishes = new ArrayList<>();
//        dishes.add(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food"));
//        dishes.add(new Dish("Quarter pound with 2 cheese", 10.0, new HashMap<>(), 400, "Food"));
//        dishes.add(new Dish("Quarter pound with 3 cheese", 10.0, new HashMap<>(), 500, "Food"));
//        dishes.add(new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food"));
//        dishes.add(new Dish("Median fries", 2.50, new HashMap<>(), 250, "Food"));
//        dishes.add(new Dish("Large fries", 3.25, new HashMap<>(), 350, "Food"));
//        dishes.add(new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink"));
//        dishes.add(new Dish("Coffee", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
//        dishes.add(new Dish("Tea", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
//        dishes.add(new Dish("Milk Tea", 10.0, new HashMap<>(), 300, "Non-Alc Drink"));
//        dishes.add(new Dish("Red Wine", 10.0, new HashMap<>(), 100, "Alcoholic Drink"));
//        return dishes;
//    }
//
//}