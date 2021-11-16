package use_case.kitchen;

import entity.orderList.Dish;
import entity.orderList.Order;

import java.util.*;

/**
 * This is the class of UseCase.PlacedOrderQueue,
 * it is used to keep track of all orders placed by customers of the restaurant.
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class OrderQueue {

    private static Queue<Order> placedOrderQueue = new ArrayDeque<Order>();

    public OrderQueue() {
        placedOrderQueue = new ArrayDeque<Order>();
    }

    /**
     * Try adding order to the placedOrderList, if order location too far or not possible to do the
     * order, reject the order.
     * @param newOrder The order to be added to the orderList
     * @return True on successful add, false on order too far or not enough ingredients
     */
    public static void addOrder(Order newOrder) throws Exception {
        // Check if the inventory is sufficient for cooking the order
        // If not enough, reject the order.
        if(!inventoryAvailable(newOrder.getDishes())) {
            throw new Exception("Inventory not available for the order");
        }
        placedOrderQueue.add(newOrder);
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
        HashMap<String, Double> ingredientsRequired = new HashMap<String, Double>(); // A dictionary with key the ingredient, 
                                                                        // value the ingredient needed
        // Calculate the total amount of each ingredient needed in the list of dishes
        for (Dish dish: dishes) {
            HashMap<String, Double> dishIngredients = dish.getIngredients();
            // Add the amount of an ingredient needed for a dish to the dictionary
            for (String ingredient: dishIngredients.keySet()) {
                if (!ingredientsRequired.containsKey(ingredient)) {
                    ingredientsRequired.put(ingredient, dishIngredients.get(ingredient));
                } else {
                    double previousValue = ingredientsRequired.get(ingredient);
                    ingredientsRequired.replace(ingredient, previousValue + dishIngredients.get(ingredient));
                }
            }
        }
        // For all the ingredients needed in the list of dishes, check if inventory is enough to do
        // If one ingredient has more needed than inventory has, we can't make the list of dishes, so return false
        for (String ingredientRequired: ingredientsRequired.keySet()) {
            if (InventoryList.getTotalQuantity(ingredientRequired) < ingredientsRequired.get(ingredientRequired)) {
                return false;
            }
        }
        return true;
    }
}