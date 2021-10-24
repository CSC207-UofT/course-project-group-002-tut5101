package use_case;

import entity.Dish;

import java.util.HashMap;

/**
 * The inventory use case responsible for managing the freshness and quantity of all inventory items.
 */

public class UpdateInventory {

    /**
     *
     * @param name The ingredient to be updated.
     * @param newFreshness The new freshness level for the ingredient.
     */
    void updateFreshness(String name, String newFreshness) {
        InventoryList.updateFreshness(name, newFreshness);
    }

    /**
     *
     * @param name The ingredient whose freshness will be checked.
     */
    void checkFreshness(String name) {
        InventoryList.getFreshness(name);
    }


    /**
     *
     * @param name The ingredient to be updated
     * @param newQuantity The new quantity for the ingredient.
     */
    void updateQuantity(String name, double newQuantity) {
        InventoryList.setQuantity(name, newQuantity);
    }


    /**
     * Update the inventory using the quantity of each ingredient that this dish needs.
     * @param dish the dish that is cooked.
     */
    private static void updateInventory(Dish dish){
        HashMap<String, Double> ingredients = dish.getIngredients();
        for (String item: ingredients.keySet()){
            double newQuantity = InventoryList.getTotalQuantity(item) - ingredients.get(item);
            InventoryList.setQuantity(item, newQuantity);
        }
        // TODO: handle cases when the new quantity is negative.
    }

    //TODO: the idea of having an automatic expire date checking function is nice. When an ingredient
    // is close to its expire date, the inventory staff should notifications regarding it.

}
