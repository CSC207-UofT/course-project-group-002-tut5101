package entity.order;

import constant.order_system.OrderType;

import java.util.HashMap;
import java.util.List;

/**
 * A Dine In Order
 */
public class DineInOrder extends Order{

    private final int tableNum;
    private final OrderType orderType;

    /**
     * initialize a dine in order
     * @param tableNum the table number the order belongs to
     * @param dishes the dishes in the order
     */
    public DineInOrder(int tableNum, HashMap<String, List<Dish>> dishes) {
        super(dishes);
        this.tableNum = tableNum;
        this.orderType = OrderType.DINE_IN;
    }

    /**
     * Get the table number to be delivered for the order
     * @return the table number of the dine-in order.
     */
    public int getTableNum() {
        return this.tableNum;
    }

    /**
     * @return the order type
     */
    public OrderType getOrderType() {
        return orderType;
    }
}
