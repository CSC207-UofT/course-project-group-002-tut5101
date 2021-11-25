package entity.orderList;

import constant.orderSystem.ItemStatus;
import constant.orderSystem.OrderType;

import java.util.HashMap;
import java.util.List;

public class DineInOrder extends Order{

    private ItemStatus orderStatus;
    private int tableNum;
    private OrderType orderType;


    public DineInOrder() {
        this.orderStatus = ItemStatus.ORDER_PLACED;
    }


    public DineInOrder(int tableNum, HashMap<String, List<Dish>> dishes) {
        super(dishes);
        this.orderStatus = ItemStatus.ORDER_PLACED;
        this.tableNum = tableNum;
    }

    /**
     * Get the table number to be delivered for the order
     * @return the table number of the dine-in order.
     */
    public int getTableNum() {
        return this.tableNum;
    }
}
