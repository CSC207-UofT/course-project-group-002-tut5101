import java.util.*;

public class RestaurantSystem {

    public static void main(String[] args) {
        logIn();
        placeOrder();

    }

    private static void logIn() {
        UserList newUsers = new UserList();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter your id");
            String id = scanner.next();
            if (newUsers.getUsers().containsKey(id)) {
                System.out.println("Enter your password");
                String password = scanner.next();
                if (newUsers.getUsers().get(id).getPassword().equals(password)) {
                    System.out.println("Succeed");
                    break;
                } else {
                    System.out.println("Failed. Enter again.");
                }
            } else {
                System.out.println("You are not a valid user. Sign up？");
            }
        }
    }

    private static void placeOrder() {
        UserList newUsers = new UserList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here is our menu.");
        System.out.println(DishList.getMenu());
        HashMap<String, Dish> menu = DishList.getMenu();
        while(true){
            System.out.println("Are you ready to order?");
            String orderYesNo = scanner.next();
            if (Objects.equals(orderYesNo, "Yes")) {
                System.out.println("Please enter your table number.");
                String tableNumber = scanner.next();
                ArrayList<Dish> dishes = new ArrayList<Dish>();
                System.out.println("Please enter a dish you would like to order. If none, enter \"Place Order\"");
                String d = scanner.next();
                while (!Objects.equals(d, "Place Order")) {
                    Dish dish = menu.get(d);
                    dishes.add(dish);
                }
                System.out.println("Order Placed");
                Order order = new Order(tableNumber, dishes);
                PlacedOrderQueue.addOrder(order);
                break;
            } else {
                System.out.println("Invalid Input.");
            }
        }
    }

}