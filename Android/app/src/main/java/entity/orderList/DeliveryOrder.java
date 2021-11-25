package entity.orderList;

import constant.orderSystem.ItemStatus;
import constant.orderSystem.OrderType;

import java.util.HashMap;
import java.util.List;

public class DeliveryOrder extends Order{

    private ItemStatus orderStatus;
    private String address;
    private OrderType orderType;

    // initialize delivery order
    public DeliveryOrder(String address, HashMap<String, List<Dish>> dishes) {
        super(dishes);
        this.orderStatus = ItemStatus.ORDER_PLACED;
        this.address = address;
    }

    /**
     * Get the address of the destination of the delivery order
     * @return the address of the destination of the order
     */
    public String getAddress() {
        return this.address;
    }
}
