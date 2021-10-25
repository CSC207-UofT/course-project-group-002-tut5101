package use_case;

import boundary.PlaceOrderInputBoundary;
import entity.Dish;
import entity.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class PlaceOrder implements PlaceOrderInputBoundary {
    public void placeOrder(boolean dineIn, String[] dishNames, String location) throws Exception{
        HashMap<String, List<Dish>> dishes = new HashMap<String, List<Dish>>();
        for (String dishName: dishNames) {

            Dish dishCopy = generateDishCopy(dishName);
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

        Order order = new Order(location, dishes);
        OrderQueue.addOrder(order);
    }

    // Lookup the dish in the DishList/Menu then create a copy of that dish
    public Dish generateDishCopy(String dishName) {
        double price = DishList.getDishPrice(dishName);
        HashMap<String, Double> ingredients = DishList.getDishIngredients(dishName);
        double calories = DishList.getDishCalories(dishName);
        Dish dishCopy = new Dish(dishName, price, ingredients, calories);
        return dishCopy;
    }
}

// Old implmentation where Order holds list of Dish names
//public class PlaceOrder implements PlaceOrderInputBoundary {
//
//    public void placeOrder(boolean dineIn, String[] dishNames, String location) throws Exception{
//        ArrayList<String[]> dishes = new ArrayList();
//        for (String dishName: dishNames) {
//            String[] dish = new String[]{dishName, ItemStatus.DISH_PLACED};
//            }
//
//        Order newOrder;
//
//        if (dineIn){
//            newOrder = new Order(Integer.parseInt(location), dishes);
//        } else {
//            newOrder = new Order(location, dishes);
//        }
//
//        OrderQueue.addOrder(newOrder);
//    }
//}
