package use_case;

import constant.ItemStatus;
import entity.Dish;
import entity.Order;

import java.util.HashMap;
import java.util.List;

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
     */
    public static void cookedDish(String dishName) {
        Dish dishCooked = currentOrder.setDishStatus(dishName);

        if (currentOrder.getOrderDineInOrTakeOut().equals("Dine In")) {
            ServingBuffer.addDish(dishCooked);
        } else if (currentOrder.getOrderStatus() == ItemStatus.ORDER_COOKED) {
            DeliveryBuffer.addDeliveryOrder(currentOrder);
        }
    }


    /**
     * @return whether the Kitchen needs a new order to cook.
     *
     * The kitchen needs a new order when they currently don't have one or when their current order
     * is all cooked.
     */
    public static boolean needNextOrder() {
        return !occupied() || currentOrder.getOrderStatus() == ItemStatus.ORDER_COOKED;
    }


    /**
     * @return whether the kitchen is occupied (has an order to work on)
     */
    public static boolean occupied() {
        return !(currentOrder == null);
    }

    /**
     * @return A string representation of the choices of dishes that still need to be cooked.
     *
     */
    public static HashMap<String, Integer> showDishesChoice() {
        HashMap<String, Integer> dishChoice = new HashMap<>();
        List<Dish> dishes = currentOrder.getDishes();
        for (Dish d: dishes) {
            if (d.getStatus() == ItemStatus.DISH_PLACED) {
                if (dishChoice.containsKey(d.getName())) {
                    dishChoice.replace(d.getName(), dishChoice.get(d.getName()) + 1);
                } else {
                    dishChoice.put(d.getName(), 1);
                }
            }
        }
        return dishChoice;
    }

}


