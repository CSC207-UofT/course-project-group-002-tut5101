package use_case.kitchen;

import constant.order_system.ItemStatus;
import constant.order_system.OrderType;
import entity.order_list.Dish;
import entity.order_list.Order;
import use_case.deliver_order.DeliveryBuffer;
import use_case.deliver_order.ServingBuffer;

import java.util.HashMap;

/**
 * The kitchen use case in the restaurant.
 *
 * Author: ௵۞ၡ֍Ѭ֍Ӂ
 */

public class Kitchen {
    /**
     * The current order that the Kitchen is working on.
     */
    private static Order currentOrder;

    /**
     * Get the next order to cook from the OrderQueue.
     *
     * @return if the Kitchen actually gets a new order.
     */
    public static boolean getNextToCook(){
        currentOrder = OrderQueue.getNextOrder();
        return !(currentOrder == null);
    }

    /**
     * reset the current class
     */
    public static void reset() {
        currentOrder = null;
    }


    /**
     * Update the status of the dish cooked. Depending on the type of the order, add the dish to
     * the ServingBuffer or add the order to DeliveryBuffer.
     *
     * @param dishName the name of the dish that is completed by the kitchen.
     */
    public static void cookedDish(String dishName) {
        Dish dishCooked = currentOrder.setDishStatus(dishName);

        if (currentOrder.getOrderType().equals(OrderType.DINE_IN)) {
            ServingBuffer.addDish(dishCooked);
        } else if (currentOrder.getOrderStatus() == ItemStatus.ORDER_COOKED) {
            DeliveryBuffer.addDeliveryOrder(currentOrder);
        }
    }


    /**
     * @return whether the Kitchen completed its current order.
     */
    public static boolean orderCompleted() {
        return currentOrder.getOrderStatus() == ItemStatus.ORDER_COOKED;
    }


    /**
     * @return whether the kitchen is occupied (has an order to work on)
     */
    public static boolean occupied() {
        return !(currentOrder == null);
    }

    /**
     * @return A hashmap of dishes with its corresponding quantity.
     */
    public static HashMap<String, Integer> dishAndQuantity() {
        return currentOrder.getDishAndQuantity();
    }

}