package use_case.placeorder;

import constant.order_system.OrderType;
import entity.order_list.DeliveryOrder;
import entity.order_list.DineInOrder;
import entity.order_list.Dish;
import entity.order_list.Order;

import java.util.HashMap;
import java.util.List;
/**
 * Use Case class for creating orders of different type.
 */
public class OrderFactory {
    /**
     * adding the review to reviewList.
     *
     * @param orderType the type of order
     * @param location location represent table or delivery address
     * @param dishes a Hashmap of dishes with key of names of dishes
     */

    public Order OrderType(OrderType orderType, String location, HashMap<String, List<Dish>> dishes) {

        if (orderType.equals(OrderType.DINE_IN)) {
            int tableNum = Integer.parseInt(location);
            return new DineInOrder(tableNum, dishes);
        }
        else {
            return new DeliveryOrder(location, dishes);
        }
    }
}
