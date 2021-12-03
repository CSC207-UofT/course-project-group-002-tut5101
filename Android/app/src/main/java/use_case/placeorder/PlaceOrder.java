package use_case.placeorder;

import android.annotation.TargetApi;
import android.os.Build;
import use_case.dishlist.DishList;
import use_case.kitchen.OrderQueue;
import entity.orderlist.Dish;
import entity.orderlist.Order;
import constant.ordersystem.OrderType;

import java.util.*;

/**
 * This is the PlaceOrder class, which creates copies of dishes ordered based on their information in the menu and creates
 * a new order with the list of dishes
 * by Evelyn Chou
 * 2021-11-03
 */
public class PlaceOrder implements PlaceOrderInputBoundary{

    private final OrderFactory orderFactory;

    public PlaceOrder() {
        orderFactory = new OrderFactory();
    }

    /**
     * Places an order by creating copies of the dishes in the menu then adding them to a new order, then adding the
     * order to the OrderQueue
     * @param orderType true if the dish is dineIn, false otherwise
     * @param dishNames string list of the names of dishes ordered
     * @param location the table number or delivery information of the order
     * @throws Exception if insufficient inventory
     */

    @TargetApi(Build.VERSION_CODES.N)
    public void placeOrder(OrderType orderType, String[] dishNames, String location) throws Exception{
        System.out.println("PLACING ORDER");
        HashMap<String, List<Dish>> dishes = new HashMap<>();

        for (String dishName: dishNames) {
            Dish dishCopy;
            dishCopy = generateDishCopy(dishName, location, orderType);

            List<Dish> dishCopyAsList;
            if (!dishes.containsKey(dishName)) {
                dishCopyAsList = new ArrayList<>(Collections.singletonList(dishCopy));
                dishes.put(dishName, dishCopyAsList);
            }
            else {
                dishCopyAsList = dishes.get(dishName);
                assert dishCopyAsList != null;
                dishCopyAsList.add(dishCopy);
                dishes.replace(dishName, dishCopyAsList);
            }
        }
        System.out.println(dishes);
        Order order = orderFactory.OrderType(orderType, location, dishes);
        System.out.println(order);
        OrderQueue.addOrder(order);
    }


    /**
     * Lookup the dish in the Menu then create a copy of that dish
     * @param dishName the name of the dish
     * @param location the table number of the dish, or location of order to be delivered
     * @param orderType whether the dish is for a dine in or take out order
     * @return a Dish with same information as the corresponding dish in the menu
     */
    public Dish generateDishCopy(String dishName, String location, OrderType orderType){
        System.out.println("GENERATE DISH COPY");
        System.out.println(dishName);
        System.out.println(location);
        System.out.println(orderType);
        System.out.println(DishList.getDishPrice(dishName));
        System.out.println(DishList.getDishIngredients(dishName));
        System.out.println(DishList.getDishCalories(dishName));


        double price = DishList.getDishPrice(dishName);
        HashMap<String, Integer> ingredients = DishList.getDishIngredients(dishName);
        double calories = DishList.getDishCalories(dishName);
        System.out.println(price);

        System.out.println(new Dish(dishName, price, ingredients, calories));

        Dish dishCopy = new Dish(dishName, price, ingredients, calories);
        System.out.println(dishCopy);
        if (orderType.equals(OrderType.DINE_IN)) {
            System.out.println("IS DINE IN");
            try {
                int tableNum = Integer.parseInt(location);
                dishCopy.setTableNum(tableNum);
            } catch (NumberFormatException ignored) {

            }
        }


        return dishCopy;
    }

}