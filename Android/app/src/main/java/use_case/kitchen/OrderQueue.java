package use_case.kitchen;

import android.os.Build;
import androidx.annotation.RequiresApi;
import entity.order.Dish;
import entity.order.Order;
import use_case.inventory.InventoryList;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * This is the class of UseCase.PlacedOrderQueue,
 * it is used to keep track of all orders placed by customers of the restaurant.
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

@SuppressWarnings("SpellCheckingInspection")
public class OrderQueue {

    private static Queue<Order> placedOrderQueue = new ArrayDeque<>();

    /**
     * reset the current class
     */
    public static void reset() {
        placedOrderQueue = new ArrayDeque<>();
    }

    /**
     * Try adding order to the placedOrderList, if order location too far or not possible to do the
     * order, reject the order.
     *
     * @param newOrder The order to be added to the orderList
     * @throws Exception throws exception on order too far or not enough ingredients
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void addOrder(Order newOrder) throws Exception {
        // Check if the inventory is sufficient for cooking the order
        // If not enough, reject the order.
        if (!inventoryAvailable(newOrder.getDishes())) {
            throw new Exception("Inventory not available for the order");
        }
        placedOrderQueue.add(newOrder);
    }

    /**
     * Get the next order in the placedOrderQueue
     *
     * @return The next order in placedOrderQueue, if placedOrderQueue empty, return null
     */
    public static Order getNextOrder() {
        return placedOrderQueue.poll();
    }


    /**
     * Check if a list of dishes can be processed given the availability of inventory provided by InventoryList
     *
     * @param dishes The list of dishes to check the ingredients availability
     * @return True when the list of dishes can be made, false otherwise.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static boolean inventoryAvailable(List<Dish> dishes) {
        if (dishes.isEmpty()) {
            return true;
        }
        HashMap<String, Integer> ingredientsRequired = new HashMap<>(); // A dictionary with key the ingredient,
        // value the ingredient needed
        // To Calculate the total amount of each ingredient needed in the list of dishes
        calculateIngredientValue(dishes, ingredientsRequired);
        // For all the ingredients needed in the list of dishes, check if inventory is enough to do
        // If one ingredient has more needed than inventory has, we can't make the list of dishes, so return false
        for (String ingredientRequired : ingredientsRequired.keySet()) {
            Integer tempIngredients = ingredientsRequired.get(ingredientRequired);
            if (tempIngredients != null) {
                int ingredients = tempIngredients;
                if (InventoryList.getTotalQuantity(ingredientRequired) < ingredients) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Calculate the total amount of each ingredient needed in the list of dishes
     *
     * @param dishes              list of dish
     * @param ingredientsRequired the required ingredients
     */
    private static void calculateIngredientValue(List<Dish> dishes, HashMap<String, Integer> ingredientsRequired) {
        for (Dish dish : dishes) {
            HashMap<String, Integer> dishIngredients = dish.getIngredients();
            // Add the amount of an ingredient needed for a dish to the dictionary
            for (String ingredient : dishIngredients.keySet()) {
                if (!ingredientsRequired.containsKey(ingredient)) {
                    ingredientsRequired.put(ingredient, dishIngredients.get(ingredient));
                } else {
                    Integer tempValue = ingredientsRequired.get(ingredient);
                    Integer tempIngredients = dishIngredients.get(ingredient);
                    if (tempValue != null && tempIngredients != null) {
                        int previousValue = tempValue;
                        int dishIngredientsTemp = tempIngredients;
                        ingredientsRequired.replace(ingredient, previousValue + dishIngredientsTemp);
                    }
                }
            }
        }
    }
}