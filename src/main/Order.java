import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    // List of order statuses
    static String PLACED = "Order Placed";
    static String COOKED = "Order Cooked";
    static String DELIVERED = "Order Delivered";
    static String COMPLETE = "Order Complete";
    static String[] statuses = new String[]{PLACED, COOKED, DELIVERED, COMPLETE};

    private List<Dish> dishes;
    private boolean dineIn;
    private String orderStatus;
    private int tableNum;
    private String address;

    // initialize dine-in order
    public Order(int tableNum, List<Dish> dishes){
        this.dishes = dishes;
        this.dineIn = true;
        this.orderStatus = PLACED;
        this.tableNum = tableNum;
    }

    // initialize delivery order
    public Order(String address, List<Dish> dishes){
        this.dishes = dishes;
        this.dineIn = false;
        this.orderStatus = PLACED;
        this.address = address;
    }


    String getOrderStatus() {
        return orderStatus;
    }

    String getOrderDineInOrTakeOut() {
        if (!this.dineIn){
            return "Take Out";
        } else {
            return "Dine In";
        }
    }


    /**
     *
     * @param dish the dish to be updated as "completed".
     * @return True if all dishes in this order are completed, otherwise return False.
     */
    boolean setDishStatusAndCheckOrderStatus(Dish dish) {
        dish.setStatus("completed");
        // Check if all dishes are complete, return false if not.
        for (Dish d:dishes) {
            if (!Objects.equals(d.getStatus(), "completed")){
                return false;
            }
        }
        // If all dishes are complete, update the order status and return true
        this.orderStatus = COOKED;
        return true;
    }

    String getString() {
        return dishes.toString();
    }

    double getOrderPrice() {
        double price = 0;
        for (Dish d: dishes) {
            price += d.getPrice();
        }
        return price;
    }

    int getTableNum() {
        return this.tableNum;
    }

    String getAddress() {
        return this.address;
    }


}
