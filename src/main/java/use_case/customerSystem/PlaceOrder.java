package use_case.customerSystem;
/**
 * This is the PlaceOrder class, which creates copies of dishes ordered based on their information in the menu and creates
 * a new order with the list of dishes
 * @Author Evelyn Chou
 * 2021-11-03
 */

import use_case.dishList.DishList;
import use_case.kitchen.OrderQueue;
import use_case.boundary.PlaceOrderInputBoundary;
import entity.Dish;
import entity.orderList.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class PlaceOrder implements PlaceOrderInputBoundary {

    /**
     * Places an order by creating copies of the dishes in the menu then adding them to a new order, then adding the
     * order to the OrderQueue
     * @param dineIn true if the dish is dineIn, false otherwise
     * @param dishNames string list of the names of dishes ordered
     * @param location the table number or delivery information of the order
     * @throws Exception
     */
    public void placeOrder(boolean dineIn, String[] dishNames, String location) throws Exception{
        HashMap<String, List<Dish>> dishes = new HashMap<String, List<Dish>>();

        for (String dishName: dishNames) {
            Dish dishCopy;
            dishCopy = generateDishCopy(dishName, location, dineIn);
            List<Dish> dishCopyAsList;
            if (!dishes.containsKey(dishName)) {
                dishCopyAsList = new ArrayList<>(Arrays.asList(dishCopy));
                dishes.put(dishName, dishCopyAsList);
            }
            else {
                dishCopyAsList = dishes.get(dishName);
                dishCopyAsList.add(dishCopy);
                dishes.replace(dishName, dishCopyAsList);
            }
        }
        Order order ;
        if (dineIn) {
            int tableNum = Integer.parseInt(location);
            order = new Order(tableNum, dishes);
        }
        else {
            order = new Order(location, dishes);
        }
        OrderQueue.addOrder(order);
    }

    /**
     * Lookup the dish in the Menu then create a copy of that dish
     * @param dishName the name of the dish
     * @param location the table number of the dish, or location of order to be delivered
     * @param dineIn whether the dish is for a dine in or take out order
     * @return a Dish with same information as the corresponding dish in the menu
     */
    public Dish generateDishCopy(String dishName, String location, boolean dineIn){
        double price = DishList.getDishPrice(dishName);
        HashMap<String, Double> ingredients = DishList.getDishIngredients(dishName);
        double calories = DishList.getDishCalories(dishName);
        String category = DishList.getDishCategory(dishName);


        Dish dishCopy = new Dish(dishName, price, ingredients, calories, category);
        if (dineIn) {
            try {
                int tableNum = Integer.parseInt(location);
                dishCopy.setTableNum(tableNum);
            } catch (NumberFormatException ignored) {

            }
        }

        return dishCopy;
    }

}