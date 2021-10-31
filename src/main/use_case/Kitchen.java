package use_case;

import constant.ItemStatus;
import entity.Dish;
import entity.Order;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * The kitchen in the restaurant.
 *
 * This class serves as an intermediate step between the customers and the delivery / serving staff.
 * It gets new orders from the placeOrderQueue, and update the status of the dish, and depending
 * on the type of the order, add the dish / order to the queues for either delivery staff or
 * serving staff.
 *
 * Author: Raymond Liu, 2021/10/11
 */

public class Kitchen {
    /**
     * The current order that the Controller.Kitchen is working on.
     */
    private static Order currentOrder;

    /**
     * Get the next order to cook from the placeOrderQueue instance.
     */
    public static boolean getNextToCook(){
        // TODO: does this really need to be a boolean return type?
        currentOrder = OrderQueue.getNextOrder();
        return currentOrder != null;
    }

    /**
     * @return the String representation of the current order.
     */
    public static String showOrder(){
        return currentOrder.toString();
    }

    /**
     * Update the status of the dish cooked. Depending on the type of the order, add the dish to
     * the ServingBuffer or add the order to DeliveryBuffer.
     *
     * @param dishName the name of the dish that is completed by the kitchen.
     * @throws Exception if the given dish name does not correspond to any dish in the current order.
     */
    public static void cookedDish(String dishName) throws Exception {
        // TODO: call the update inventory in controller.
        Dish dishCooked = currentOrder.setDishStatus(dishName);
        ItemStatus orderCompleted = currentOrder.getOrderStatus();
        if (currentOrder.getOrderDineInOrTakeOut().equals("Dine In")){
            ServingBuffer.addDish(dishCooked);
            if (orderCompleted == ItemStatus.ORDER_COOKED){
                getNextToCook();
            }
        } else {
            if (orderCompleted == ItemStatus.ORDER_COOKED) {
                DeliveryBuffer.addDeliveryOrder(currentOrder);
                getNextToCook();
            }
        }
    }
}


