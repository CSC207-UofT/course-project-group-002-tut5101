package main;

import java.util.ArrayList;
import java.util.List;

/**
This is the class of Orderlist, it is used to keep track of all orders of the restaurant
 */
public class OrderList {

    private List<Order> orderList;

    public void OrderList() {
        orderList = new ArrayList<Order>();
    }

    /**
     * Try adding order to the order list, if order location too far, reject the order.
     * @param newOrder The order to be added to the orderList
     * @return True on successful add, false otherwise
     */
    public boolean addOrder(Order newOrder) {
        /*
        if (newOrder.getdistance() > RestaurantInfo.DELIVERY_RANGE) {
            return false;
        }
        */
        orderList.add(newOrder);
        return true;
    }

    /**
     * Get the next order in the orderList to be cooked, if no order found, return null
     * @return The next order in orderList to be cooked, if no next order, return null
     */
    public Order getNextOrderToBeCooked() {
        for (Order order: orderList) {
            if (order.getOrderStatus() == Order.ORDER_PLACED) {
                return order;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}