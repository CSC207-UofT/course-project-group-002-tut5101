package main;

import java.util.List;

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
        if (this.dineIn == false){
            return "Take Out";
        }
        else {
            return "Dine In";
        }
    }

    boolean setDishStatus(Dish dish, String status) {
        dish.setStatus(status);
        boolean allComplete = true;
        // Check if all dishes are complete
        for (Dish d:dishes) {
            if (d.getStatus() != "complete"){
                allComplete = false;
            }
        }
        // If all dishes are complete, update the order status
        if (allComplete == true) {
            setOrderStatus(COMPLETE);
        }
        return true;

    }

    boolean setOrderStatus(String status) {
        //TODO: check if status is one of the allowable statuses
        this.orderStatus = status;
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
