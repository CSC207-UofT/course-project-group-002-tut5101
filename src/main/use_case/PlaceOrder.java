package use_case;

import boundary.PlaceOrderInputBoundary;
import constant.ItemStatus;
import entity.Order;

import java.util.ArrayList;


public class PlaceOrder implements PlaceOrderInputBoundary {

    public void placeOrder(boolean dineIn, String[] dishNames, String location) throws Exception{
        ArrayList<String[]> dishes = new ArrayList();
        for (String dishName: dishNames) {
            String[] dish = new String[]{dishName, ItemStatus.DISH_PLACED};
            }

        Order newOrder;

        if (dineIn){
            newOrder = new Order(Integer.parseInt(location), dishes);
        } else {
            newOrder = new Order(location, dishes);
        }

        OrderQueue.addOrder(newOrder);
    }
}
