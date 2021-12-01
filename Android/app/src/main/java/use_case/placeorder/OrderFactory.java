package use_case.placeorder;

import constant.ordersystem.OrderType;
import entity.orderlist.DeliveryOrder;
import entity.orderlist.DineInOrder;
import entity.orderlist.Dish;
import entity.orderlist.Order;

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
