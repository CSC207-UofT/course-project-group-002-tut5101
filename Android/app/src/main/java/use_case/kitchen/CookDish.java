package use_case.kitchen;

import constant.order_system.ItemStatus;
import constant.order_system.OrderType;
import entity.order.Dish;
import entity.order.Order;
import use_case.deliver_order.DeliveryBuffer;
import use_case.deliver_order.ServingBuffer;
import use_case.kitchen.boundary.KitchenOutputBoundary;


/**
 * The kitchen use case in the restaurant.
 * Author: Raymond
 */

public class CookDish {
    /**
     * The current order that the Kitchen is working on.
     */
    private static Order currentOrder;
    private final KitchenOutputBoundary kob;

    public CookDish(KitchenOutputBoundary kob) {
        this.kob = kob;
    }

    /**
     * Get the next order to cook from the OrderQueue.
     *
     * @return if the Kitchen actually gets a new order.
     */
    public boolean getNextToCook() {
        currentOrder = OrderQueue.getNextOrder();
        return !(currentOrder == null);
    }


    /**
     * Update the status of the dish cooked. Depending on the type of the order, add the dish to
     * the ServingBuffer or add the order to DeliveryBuffer.
     *
     * @param dishName the name of the dish that is completed by the kitchen.
     */
    public void cookedDish(String dishName) {
        Dish dishCooked = currentOrder.setDishStatus(dishName);

        if (currentOrder.getOrderType().equals(OrderType.DINE_IN)) {
            ServingBuffer.addDish(dishCooked);
        } else if (currentOrder.getOrderStatus() == ItemStatus.ORDER_COOKED) {
            DeliveryBuffer.addDeliveryOrder(currentOrder);
        }
    }


    /**
     * Return true if the order status is completed.
     *
     * @return whether the Kitchen completed its current order.
     */
    private boolean orderCompleted() {
        return currentOrder.getOrderStatus() == ItemStatus.ORDER_COOKED;
    }


    /**
     * Return true if the kitchen is occupied.
     *
     * @return whether the kitchen is occupied (has an order to work on)
     */
    private boolean occupied() {
        return !(currentOrder == null);
    }


    /**
     * 1. If there is an incomplete one, return true.
     * 2. If the current one is complete, and a new one was able to obtain, return true. Otherwise,
     * return false.
     * 3. If there is no order, and a new one was able to obtain, return true. Otherwise,
     * return false.
     * <p>
     * dishes is updated whenever a new order is obtained for Kitchen.
     *
     * @return whether a new order is obtained.
     */
    public boolean getAvailableOrder() {
        if (occupied()) {
            if (orderCompleted()) {
                if (getNextToCook()) {
                    kob.getNextOrder(currentOrder.getDishAndQuantity());
                    return true;
                }
            }
        } else if (getNextToCook()) {
            kob.getNextOrder(currentOrder.getDishAndQuantity());
            return true;
        }
        return false;
    }

}