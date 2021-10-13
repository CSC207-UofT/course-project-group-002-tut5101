import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * This is the class of PlacedOrderQueue,
 * it is used to keep track of all orders placed by customers of the restaurant.
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class PlacedOrderQueue {

    private static Queue<Order> placedOrderQueue;

    public PlacedOrderQueue() {
        placedOrderQueue = new ArrayDeque<Order>();
    }

    /**
     * Try adding order to the placedOrderList, if order location too far or not possible to do the
     * order, reject the order.
     * @param newOrder The order to be added to the orderList
     * @return True on successful add, false on order too far or not enough ingredients
     */
    public static boolean addOrder(Order newOrder) {
        // TODO: Check if the distance is out of range of delivery for delivery
        // Assume it is called Map to get distance of points on the map
        /*
        if (newOrder.getOrderDineInOrTakeOut() == "take out" &&
                Map.getDistance(newOrder.getAddress(), RestaurantInfo.ADDRESS) > RestaurantInfo.DELIVERY_RANGE) {
            return false;
        }
         */
        //TODO: Check if the inventory is enough for cooking the order
        // If not enough, reject the order.
        //TODO: think about how to handle cases where the ingredients for two or more dishes are
        // unavailable, but rejecting some dishes makes the other ones available.
        placedOrderQueue.add(newOrder);
        return true;
    }

    /**
     * Get the next order in the placedOrderQueue
     * @return The next order in placedOrderQueue, if placedOrderQueue empty, return null
     */
    public Order getNextOrder() {
        return placedOrderQueue.poll();
    }
}