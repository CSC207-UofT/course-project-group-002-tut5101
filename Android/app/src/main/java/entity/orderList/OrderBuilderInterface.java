package entity.orderList;

import java.util.HashMap;
import java.util.List;

public interface OrderBuilderInterface {
    void reset();

    void setDishes();

    void setOrderType();

    void setOrderStatus();

    void setTableNumber();



    Order getProduct();


}
