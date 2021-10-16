package use_case;

import entity.Staff;

/**
 * The inventory staff responsible for managing the freshness and quantity of all inventory items.
 */

public class InventoryStaff extends Staff {

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

    //TODO: the idea of having an automatic expire date checking function is nice. When an ingredient
    // is close to its expire date, the inventory staff should notifications regarding it.


}
