package use_case;

import entity.Dish;
import entity.Order;

import java.util.*;

/**
 * This is the class of UseCase.PlacedOrderQueue,
 * it is used to keep track of all orders placed by customers of the restaurant.
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class PlacedOrderQueue {

    private static Queue<Order> placedOrderQueue = new ArrayDeque<Order>();

    public PlacedOrderQueue() {
        placedOrderQueue = new ArrayDeque<Order>();
    }

    /**
     * Try adding order to the placedOrderList, if order location too far or not possible to do the
     * order, reject the order.
     * @param newOrder The order to be added to the orderList
     * @return True on successful add, false on order too far or not enough ingredients
     */
    public static boolean addOrder(Order newOrder) {
        // TODO: Check if the distance is out of range of delivery for delivery
        // Assume it is called Map to get distance of points on the map
        /*
        if (newOrder.getOrderDineInOrTakeOut() == "take out" &&
                Map.getDistance(newOrder.getAddress(), UseCase.RestaurantInfo.ADDRESS) > UseCase.RestaurantInfo.DELIVERY_RANGE) {
            return false;
        }
         */
        // Check if the inventory is enough for cooking the order
        // If not enough, reject the order.
        if(!inventoryAvailable(newOrder.getDishes())) {
            System.out.println("No enough ingredients");
            return false;
        }
        System.out.println("Try to add");
        placedOrderQueue.add(newOrder);
        System.out.println("Added successfully");
        return true;
    }

    /**
     * Get the next order in the placedOrderQueue
     * @return The next order in placedOrderQueue, if placedOrderQueue empty, return null
     */
    public static Order getNextOrder() {
        return placedOrderQueue.poll();
    }


    /**
     * Check if a list of dishes can be processed given the availability of inventory provided by InventoryList
     * @param dishes The list of dishes to check the ingredients availability
     * @return True when the list of dishes can be made, false otherwise.
     */
    private static boolean inventoryAvailable(List<Dish> dishes) {
        if (dishes.isEmpty()) {
            return true;
        }
        HashMap<String, Double> ingredientsRequired = new HashMap<String, Double>();
        for (Dish dish: dishes) {
            HashMap<String, Double> dishIngredients = dish.getIngredients();
            for (String ingredient: dishIngredients.keySet()) {
                if (!ingredientsRequired.containsKey(ingredient)) {
                    ingredientsRequired.put(ingredient, dishIngredients.get(ingredient));
                } else {
                    double previousValue = ingredientsRequired.get(ingredient);
                    ingredientsRequired.replace(ingredient, previousValue + dishIngredients.get(ingredient));
                }
            }
        }
        for (String ingredientRequired: ingredientsRequired.keySet()) {
            if (InventoryList.getTotalQuantity(ingredientRequired) < ingredientsRequired.get(ingredientRequired)) {
                return false;
            }
        }
        return true;
    }
}