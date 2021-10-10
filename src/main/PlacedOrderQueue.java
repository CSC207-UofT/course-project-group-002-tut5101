package main;

import java.util.Queue;
import java.util.ArrayDeque;

/**
This is the class of Orderlist, it is used to keep track of all orders of the restaurant
 */
public class PlacedOrderQueue {

    private Queue<Order> placedOrderQueue;

    public void PlacedOrderQueue() {
        placedOrderQueue = new ArrayDeque<Order>();
    }

    /**
     * Try adding order to the order list, if order location too far or not possible to do the order,
     * reject the order.
     * @param newOrder The order to be added to the orderList
     * @return True on successful add, false on order too far or not enough ingredients
     */
    public boolean addOrder(Order newOrder) {
        // TODO: Check if the distance is out of range of delivery for delivery
        // Assume it is called Map to get distance of points on the map
        if (newOrder.getOrderDineInOrTakeOut() == "take out" &&
                Map.getDistance(newOrder.getAddress(), RestaurantInfo.ADDRESS) > RestaurantInfo.DELIVERY_RANGE) {
            return false;
        }
        //TODO: Check if the inventory is enough for cooking the order
        // If not enough, reject the order
        placedOrderQueue.add(newOrder);
        return true;
    }

    /**
     * Get the next order in the orderQueue, if no order found, return null
     * @return The next order in orderQueue, if orderList empty, return null
     */
    public Order getNextOrder() {
        return placedOrderQueue.poll();
    }
}