package use_case.placeorder;

import android.annotation.TargetApi;
import android.os.Build;
import constant.order_system.OrderType;
import entity.order.Dish;
import entity.order.Order;
import use_case.dish_list.DishList;
import use_case.kitchen.OrderQueue;
import use_case.placeorder.boundaries.PlaceOrderInputBoundary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * This is the PlaceOrder class, which creates copies of dishes ordered based on their information in the menu and creates
 * a new order with the list of dishes
 * by Evelyn Chou
 * 2021-11-03
 */
public class PlaceOrder implements PlaceOrderInputBoundary {

    private final OrderFactory orderFactory;

    public PlaceOrder() {
        orderFactory = new OrderFactory();
    }

    /**
     * Places an order by creating copies of the dishes in the menu then adding them to a new order, then adding the
     * order to the OrderQueue
     *
     * @param orderType true if the dish is dineIn, false otherwise
     * @param dishNames string list of the names of dishes ordered
     * @param location  the table number or delivery information of the order
     * @throws Exception if insufficient inventory
     */

    @TargetApi(Build.VERSION_CODES.N)
    public void placeOrder(OrderType orderType, String[] dishNames, String location) throws Exception {

        HashMap<String, List<Dish>> dishes = new HashMap<>();

        for (String dishName : dishNames) {
            Dish dishCopy;
            dishCopy = generateDishCopy(dishName, location, orderType);

            List<Dish> dishCopyAsList;
            if (!dishes.containsKey(dishName)) {
                dishCopyAsList = new ArrayList<>(Collections.singletonList(dishCopy));
                dishes.put(dishName, dishCopyAsList);
            } else {
                dishCopyAsList = dishes.get(dishName);
                assert dishCopyAsList != null;
                dishCopyAsList.add(dishCopy);
                dishes.replace(dishName, dishCopyAsList);
            }
        }
        Order order = orderFactory.OrderType(orderType, location, dishes);
        OrderQueue.addOrder(order);

    }


    /**
     * Lookup the dish in the Menu then create a copy of that dish
     *
     * @param dishName  the name of the dish
     * @param location  the table number of the dish, or location of order to be delivered
     * @param orderType whether the dish is for a dine-in or take out order
     * @return a Dish with same information as the corresponding dish in the menu
     */
    public Dish generateDishCopy(String dishName, String location, OrderType orderType) {

        double price = DishList.getDishPrice(dishName);
        HashMap<String, Integer> ingredients = DishList.getDishIngredients(dishName);
        double calories = DishList.getDishCalories(dishName);

        Dish dishCopy = new Dish(dishName, price, ingredients, calories);
        if (orderType.equals(OrderType.DINE_IN)) {
            try {
                int tableNum = Integer.parseInt(location);
                dishCopy.setTableNum(tableNum);
            } catch (NumberFormatException ignored) {

            }
        }
        return dishCopy;
    }

}