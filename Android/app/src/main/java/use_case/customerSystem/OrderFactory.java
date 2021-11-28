package use_case.customerSystem;

import constant.orderSystem.OrderType;
import entity.orderList.DeliveryOrder;
import entity.orderList.DineInOrder;
import entity.orderList.Dish;
import entity.orderList.Order;

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
