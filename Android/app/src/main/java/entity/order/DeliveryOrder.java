package entity.order;

import constant.order_system.OrderType;

import java.util.HashMap;
import java.util.List;

/**
 * A Delivery Order
 */
public class DeliveryOrder extends Order{

    private final String address;
    private final OrderType orderType;

    /**
     * initialize a delivery order
     * @param address the address for the order to be delivered to
     * @param dishes the dishes ordered
     */
    public DeliveryOrder(String address, HashMap<String, List<Dish>> dishes) {
        super(dishes);
        this.address = address;
        this.orderType = OrderType.DELIVERY;
    }

    /**
     * Get the address of the destination of the delivery order
     * @return the address of the destination of the order
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @return the order type
     */
    public OrderType getOrderType() {
        return orderType;
    }

}
