package entity.orderList;

import constant.orderSystem.ItemStatus;
import constant.orderSystem.OrderType;

import java.util.HashMap;
import java.util.List;

public class DineInOrder extends Order{

    private int tableNum;
    private OrderType orderType;



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
     *
     * @return the order type
     */
    public OrderType getOrderType() {
        return orderType;
    }
}
