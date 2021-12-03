package use_case.placeorder;

import constant.ordersystem.OrderType;
import entity.order_system.DeliveryOrder;
import entity.order_system.DineInOrder;
import entity.order_system.Dish;
import entity.order_system.Order;

import java.util.HashMap;
import java.util.List;

public class OrderFactory {

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
