package entity.orderList;

import constant.orderSystem.OrderType;

import java.util.HashMap;
import java.util.List;

public interface OrderBuilderInterface {
    void reset();

    void setDishes(HashMap<String, List<Dish>> dishes);

    void addDish(String dishName, Dish dish);

    void setOrderType(OrderType orderType);

    Order getProduct();


}
