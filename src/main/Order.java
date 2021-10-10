package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Order {
    static String PLACED = "Order Placed";
    static String COOKED = "Order Cooked";
    static String DELIVERED = "Order Delivered";
    static String COMPLETE = "Order Complete";
    private String[] statuses = new String[]{PLACED, COOKED, DELIVERED, COMPLETE};

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


    String GetOrderStatus() {
        return orderStatus;
    }

    boolean updateDishStatus(String status, Dish dish) {
        // add the update dish status function here
    }

    boolean updateOrderStatus(String status) {
        //check if status is one of the allowable statuses
        this.orderStatus = status;
        return true;
    }

    String getString() {
        return dishes.toString();
    }

    int orderPrice() {
        int price = 0;
        for (Dish d: dishes) {
            // add each dish price to price
        }
        return price;
    }


}
