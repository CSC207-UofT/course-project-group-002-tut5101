import java.util.Scanner;

public class RestaurantSystem {

    public static void main(String[] args) {
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
}