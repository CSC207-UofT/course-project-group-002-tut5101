import java.util.*;

public class RestaurantSystem {

    private static final UserList userList;
    private static final List<Dish> menu;
    private static boolean login;
    private static User currentUser;


    static {
        userList = generateUserList();
        menu = generateDishList();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (login) {
                if (currentUser instanceof Customer) {
                    String actions = "Welcome!\nPlease enter number of the action listed below:\n" +
                            "1. Place Order\n" +
                            "2. Ask for assistance\n" +
                            "3. Pay bill\n" +
                            "0. Logout";
                    int selectedAction = actionPicker(actions, scanner);

                    switch (selectedAction) {
                        case 0:
                            login = false;
                            break;
                        case 1:
                            System.out.println(displayMenu());
                            System.out.println("Please enter the dish number you want to order (separate by a enter and ends by 'q'):");
                            ArrayList<Integer> orderedNum = new ArrayList();
                            while (scanner.hasNextInt()){
                                orderedNum.add(scanner.nextInt());
                            }
                            System.out.println("Please confirm your orders [y/n]:");
                            for (int num : orderedNum) {
                                System.out.println(menu.get(num - 1));
                            }
                            scanner.next();
                            String ans = scanner.next();
                            if (ans.equals("y")) {
                                List<Dish> orderedDishes = new ArrayList<Dish>();
                                for (int num : orderedNum) {
                                    orderedDishes.add(menu.get(num-1));
                                }
                                Order customerOrder = new Order(1, orderedDishes);
                                System.out.println(customerOrder.toString());
                                if (!PlacedOrderQueue.addOrder(customerOrder)) {
                                    System.out.println("Your order cannot be placed\n\n");
                                    break;
                                }
                                System.out.println("Your order has been placed, please wait...\n\n");
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                } else if (currentUser instanceof Manager) {
                    String actionList = "Welcome Back! Please enter number of the action listed below:\n" +
                            "1. View uncompleted orders\n" +
                            "0. Logout";
                    actionPicker(actionList, scanner);
                } else if (currentUser instanceof ServingStaff) {
                    String actionList = "Welcome Back! Please enter number of the action listed below:\n" +
                            "1. View dish to be served\n" +
                            "2. Mark dish as served\n" +
                            "0. Logout";
                    ServingStaff currentServingStaff = ((ServingStaff) currentUser);
                    int action = actionPicker(actionList, scanner);
                    switch (action) {
                        case 0:
                            login = false;
                            break;
                        case 1:
                            if (currentServingStaff.getServeDish()) {
                                System.out.println("Table: " + currentServingStaff.getTableNum() +
                                        "Dish: " + currentServingStaff.getDish().toString());
                            } else {
                                System.out.println("Currently no dish to be served");
                            }
                            break;
                        case 2:
                            if (currentServingStaff.completeDish()) {
                                System.out.println("Dish marked as completed");
                            } else {
                                System.out.println("You served air!");
                            }
                            break;
                    }
                } else if (currentUser == null) {
                    System.out.println("You have login as the kitchen");
                    StringBuilder actionList = new StringBuilder("Welcome Back! Please enter number of the action listed below:\n" +
                            "1. View order to be cooked\n" +
                            "2. Mark dish as cooked\n" +
                            "0. Logout");
                    int action = actionPicker(actionList.toString(), scanner);
                    switch (action) {
                        case 0:
                            login = false;
                            break;
                        case 1:
                            if (Kitchen.getNextToCook()) {
                                System.out.println("Cooking " + Kitchen.getCurrentOrder().toString());
                            } else {
                                System.out.println("No order to be cooked");
                            }
                            break;
                        case 2:
                            actionList = new StringBuilder();
                            List<Dish> dishList = Kitchen.getCurrentOrder().getDishes();
                            for (int i = 1; i <= dishList.size(); i++) {
                                actionList.append(i).append(" ").append(dishList.get(i-1).getName()).append("\n");
                            }
                            int dishToBeCooked = actionPicker(actionList.toString(), scanner);
                            if (1 <= dishToBeCooked && dishToBeCooked <= dishList.size()) {
                                Kitchen.cookedDish(dishList.get(dishToBeCooked-1));
                            } else {
                                System.out.println("Invalid dish number: " + dishToBeCooked);
                            }
                            break;
                    }
                } else {
                    login = false;
                }
            } else {
                userLoginHelper(scanner);
            }
        }
    }

    private static String displayMenu() {
        StringBuilder menuString = new StringBuilder();
        menuString.append("\n~~~~~~~~~~~~~~~~~~~ M E N U ~~~~~~~~~~~~~~~~~~~~~\n");
        for (int i = 0; i < menu.size(); i++) {
            menuString.append(i + 1).append(". ").append(menu.get(i).toString());
        }
        return menuString.toString();
    }

    public static int actionPicker(String actionList, Scanner scanner) {
        System.out.println(actionList);
        int selectedAction = scanner.nextInt();
        login = selectedAction != 0;
        return selectedAction;
    }

    /**
     * Helper method of user login
     *
     * @param scanner System input
     */
    private static void userLoginHelper(Scanner scanner) {
        System.out.print("Please enter your id: ");
        String id = scanner.next();
        if (Objects.equals(id, "0")) {
            currentUser = null;
            login = true;
            return;
        }
        if (userList.getUsers().containsKey(id)) {
            System.out.print("Please enter your password: ");
            String password = scanner.next();
            if (userList.getUsers().get(id).getPassword().equals(password)) {
                login = true;
                currentUser = userList.getUsers().get(id);
            } else {
                System.out.println("Login Failed. Please ask for assistance.");
            }
        } else {
            System.out.println("Do you want to sign up？");
        }
    }

    /**
     * Generate the UserList
     *
     * @return a Hashmap mapping user ids to Users
     */
    public static UserList generateUserList() {
        UserList userList = new UserList();
        userList.getUsers().put("1", new Manager("1", "Chan", "12345"));
        userList.getUsers().put("2", new Customer("2", "Howard", "12345"));
        userList.getUsers().put("3", new Manager("3", "Nathan", "12345"));
        userList.getUsers().put("4", new Customer("4", "George", "12345"));
        userList.getUsers().put("5", new Manager("5", "DeDong", "12345"));
        userList.getUsers().put("6", new Customer("6", "Eve", "12345"));
        userList.getUsers().put("7", new Manager("7", "Raymond", "12345"));
        userList.getUsers().put("8", new ServingStaff("8", "Tom", "12345", 4000));
        return userList;
    }

    /**
     * This method is used to generate a list of dishes that used to display to users
     *
     * @return a HashMap mapping dish name and the dish
     */
    public static ArrayList<Dish> generateDishList() {
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food"));
        dishes.add(new Dish("Quarter pound with 2 cheese", 10.0, new HashMap<>(), 400, "Food"));
        dishes.add(new Dish("Quarter pound with 3 cheese", 10.0, new HashMap<>(), 500, "Food"));
        dishes.add(new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food"));
        dishes.add(new Dish("Median fries", 2.50, new HashMap<>(), 250, "Food"));
        dishes.add(new Dish("Large fries", 3.25, new HashMap<>(), 350, "Food"));
        dishes.add(new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink"));
        dishes.add(new Dish("Coffee", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
        dishes.add(new Dish("Tea", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
        dishes.add(new Dish("Milk Tea", 10.0, new HashMap<>(), 300, "Non-Alc Drink"));
        dishes.add(new Dish("Red Wine", 10.0, new HashMap<>(), 100, "Alcoholic Drink"));
        return dishes;
    }

}