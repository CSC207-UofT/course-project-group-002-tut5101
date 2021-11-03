package controller;

import use_case.DishList;
import use_case.InventoryList;
import use_case.Kitchen;
import use_case.OrderQueue;

import java.util.HashMap;


/**
 * Controller for Kitchen.
 *
 * Display and update the list of dishes to be completed by the kitchen.
 * Allow the kitchen user to view the ingredients needed for a dish.
 * Mark a given dish as completed in the collection dishes, and decreases its quantity by 1 or remove
 * it from the collection.
 * Return notification if a new order comes for the kitchen.
 *
 * Author: ௵۞ၡ֍Ѭ֍Ӂ
 *
 */

public class KitchenController {


    /**
     * A collection of dishes to be completed by the Kitchen. Each key is a dish name, corresponding
     * to its quantity.
     */
    HashMap<String, Integer> dishes;

    /**
     *
     * @return whether the Kitchen has an order to be processed on.
     * 1. If there is an incomplete one, return true.
     * 2. If the current one is complete, and a new one was able to obtain, return true. Otherwise,
     * return false.
     * 3. If there is no order, and a new one was able to obtain, return true. Otherwise,
     * return false.
     *
     * dishes is updated whenever a new order is obtained for Kitchen.
     *
     */
    public boolean hasOrder(){
        if (Kitchen.occupied()) {
            if (Kitchen.orderCompleted()) {
                if (Kitchen.getNextToCook()) {
                    dishes = Kitchen.dishAndQuantity();
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } else if (Kitchen.getNextToCook()) {
            dishes = Kitchen.dishAndQuantity();
            return true;
        }
        return false;
    }


    /**
     * Show a list of dishes for the Kitchen to complete.
     * E.g.
     * # Name ---- Quantity #
     *   Fries     1
     *   Burger    2
     *   ...
     * ----------------------
     *
     * @return The String representation of the list of dishes.
     */
    public String showDishes() {
        StringBuilder sb = new StringBuilder();
        sb.append("# Name ---- Quantity #\n");
        for (String dish: dishes.keySet()) {
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < 10 - dish.length(); i++){
                space.append(" ");
            }
            sb.append("# " + dish + space + dishes.get(dish) + "\n");
        }
        return sb.toString();
    }

    /**
     * Display the ingredients for a given dish.
     * @param dishName The name of the dish whose ingredients will be displayed.
     * @return A string representation of the ingredients.
     */
    public String displayIngredient(String dishName) {
        HashMap<String, Double> in = DishList.getDishIngredients(dishName);
        StringBuilder sb = new StringBuilder();
        sb.append(dishName + "\n" + "# Ingredient ---- Quantity #\n");
        for (String ingreName: in.keySet()) {
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < 16 - ingreName.length(); i++){
                space.append(" ");
            }
            sb.append("# " + ingreName + space + in.get(ingreName) + "\n");
        }
        return sb.toString();
    }


    /**
     * Mark the given dish as cooked.
     * Update the inventory.
     *
     * If the given dish is all completed in dishes, remove this element from dishes. Otherwise,
     * decreases the quantity of this dish by 1.
     *
     *
     * @param dishName One of the dish choices provided to Kitchen in showDishToCook.
     */
    public void completeDish(String dishName) {
        // Since more clever design (such as button) will be later implemented. There is no
        // need to check if the given dishName is valid.
        Kitchen.cookedDish(dishName);
        updateInventory(dishName);

        if (dishes.get(dishName) > 1) {
            dishes.replace(dishName, dishes.get(dishName) - 1);
        } else {
            dishes.remove(dishName);
        }
    }


    /**
     * Update the inventory according to the ingredients used in the given dish name.
     * @param dishName The name of the cooked dish
     */
    private void updateInventory(String dishName) {
        HashMap<String, Double> ingredientInfo = DishList.getDishIngredients(dishName);

        for (String dish: ingredientInfo.keySet()) {
            double oriQuantity = InventoryList.getTotalQuantity(dish);
            InventoryList.setQuantity(dish, oriQuantity - ingredientInfo.get(dish));
        }
    }



}