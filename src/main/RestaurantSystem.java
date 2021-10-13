import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println(DishList.getDishes());
        while(true){
            System.out.println("Are you ready to order?");
            String orderYesNo = scanner.next();
            if (orderYesNo == "Yes") {
                System.out.println("Please enter your table number.");
                String tableNumber = scanner.next();
                ArrayList<Dish> dishes = null;
                System.out.println("Please enter a dish you would like to order. If none, enter \"Place Order\"");
                String dish = scanner.next();
                boolean b = dish != "Place Order";
                while (b == true) {
                new Dish(dish); //how to create Dish from dish name
                dishes.add(dish);
                }
                Order order = new Order(tableNumber, dishes);
                PlacedOrderQueue.addOrder(order);
            } else {
                System.out.println("Invalid Input.");
            }
        }
    }

}