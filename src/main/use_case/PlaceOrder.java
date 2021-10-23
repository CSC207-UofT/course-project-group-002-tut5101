package use_case;

import entity.Dish;
import entity.Order;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrder {

    public static void placeOrder(boolean dineIn, String[] dishNames, String location) throws Exception {
        List<Dish> dishes = new ArrayList<>();
        for (String dishName: dishNames){
            dishes.add(DishList.getDish(dishName));
        }

        Order newOrder;

        if (dineIn){
            newOrder = new Order(Integer.parseInt(location), dishes);
        } else {
            newOrder = new Order(location, dishes);
        }

        OrderQueue.addOrder(newOrder);
        // TODO: Catch this exception in the UI
    }
}
