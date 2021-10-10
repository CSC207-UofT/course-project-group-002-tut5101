import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Order {
    String PLACED = "Order Placed";
    String COOKED = "Order Cooked";
    String DELIVERED = "Order Delivered";
    String COMPLETE = "Order Complete";
    private String[] statuses = new String[]{PLACED, COOKED, DELIVERED, COMPLETE};

    private List<Dish> dishes;
    private boolean dineIn;
    private String orderStatus;
    private int tableNum;

    public Order(int tableNum, List<Dish> dishes, boolean dineIn){
        this.dishes = dishes;
        this.dineIn = dineIn;
        this.orderStatus = PLACED;
        this.tableNum = tableNum;

    }

    String GetOrderStatus() {
        return orderStatus;
    }

    boolean UpdateDishStatus(String status, Dish dish) {
        // add the update dish status function here
    }

    boolean UpdateOrderStatus(String status) {
        //check if status is one of the allowable statuses
        this.orderStatus = status;
        return true;
    }

}
