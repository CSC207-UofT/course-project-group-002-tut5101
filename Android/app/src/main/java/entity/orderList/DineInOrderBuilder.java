package entity.orderList;

import constant.orderSystem.OrderType;

import java.util.HashMap;
import java.util.List;

public class DineInOrderBuilder implements OrderBuilderInterface{
    int tableNum;
    HashMap<String, List<Dish>> dishes;
    DineInOrder dineInOrder;

    public DineInOrderBuilder(int tableNum, HashMap<String, List<Dish>> dishes) {
        this.tableNum = tableNum;
        this.dishes = dishes;
        this.reset();
    }

    @Override
    public void reset() {
        dineInOrder = new DineInOrder();
    }

    @Override
    public void setDishes(HashMap<String, List<Dish>> dishes) {

    }

    @Override
    public void addDish(String dishName, Dish dish){

    }

    @Override
    public void setOrderType(OrderType orderType) {

    }

    public void setTableNumber(int tableNum) {
        this.tableNum = tableNum;
    }

    @Override
    public Order getProduct() {
        return null;
    }
}
