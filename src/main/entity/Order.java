package entity;


import java.util.List;
import java.util.Objects;


public class Order {
    // List of order statuses
    static String PLACED = "Order Placed";
    static String COOKED = "Order Cooked";
    static String DELIVERED = "Order Delivered";
    static String COMPLETE = "Order Complete";

    public enum Status {
        PLACED,
        COOKED,
        DELIVERED,
        COMPLETE
    }

    private List<Dish> dishes;
    private boolean dineIn;
    private Status orderStatus;
    private int tableNum;
    private String address;

    // initialize dine-in order
    public Order(int tableNum, List<Dish> dishes){
        this.dishes = dishes;
        this.dineIn = true;
        this.orderStatus = Status.PLACED;
        this.tableNum = tableNum;
    }

    // initialize delivery order
    public Order(String address, List<Dish> dishes){
        this.dishes = dishes;
        this.dineIn = false;
        this.orderStatus = Status.PLACED;
        this.address = address;
    }

    public String getOrderStatus() {
        return orderStatus.toString();
    }

    public String getOrderDineInOrTakeOut() {
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
    public boolean setDishStatusAndCheckOrderStatus(Dish dish) {
        dish.setStatus("completed");
        // Check if all dishes are complete, return false if not.
        for (Dish d:dishes) {
            if (!Objects.equals(d.getStatus(), "completed")){
                return false;
            }
        }
        // If all dishes are complete, update the order status and return true
        this.orderStatus = Status.COOKED;
        return true;
    }

    /**
     * Returns provided STRING argument.
     * @param status is the status to set the order as
     * @throws Exception status is not one of the allowable status in statuses
     */
    public void setOrderStatus(Status status) {
        //TODO: throw exception if status is not one of the allowable status in statuses
        this.orderStatus = status;
    }


    @Override
    public String toString() {
        return dishes.toString();
    }

    public double getOrderPrice() {
        double price = 0;
        for (Dish d: dishes) {
            price += d.getPrice();
        }
        return price;
    }

    public int getTableNum() {
        return this.tableNum;
    }

    public String getAddress() {
        return this.address;
    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

}
