package controller;

import use_case.DishList;
import use_case.InventoryList;
import use_case.Kitchen;
import use_case.OrderQueue;

import java.util.HashMap;


/**
 * Controller for Kitchen.
 */


//TODO: I WANT TO MAKE KITCHEN A LISTENER TO ORDER QUEUE, WHICH MAKES MUCH MORE SENSE MORE THE
// CURRENT IMPLEMENTATION

public class KitchenController {
    HashMap<String, Integer> dishChoices;

    /**
     * @return the String info of the current order in Kitchen if there is one, or if the Kitchen needs
     * one and the newly obtained one is not null.
     */
    public String showOrder() {
        if (Kitchen.occupied() || (Kitchen.needNextOrder() && Kitchen.getNextToCook())) {
            return Kitchen.showOrder();
        }
        return "No order yet";
    }


    /**
     * Show a list of dish choices for the Kitchen to select.
     * E.g.
     * Name      quantity
     * Fries     1
     * Burger    2
     * ...
     *
     * @return The String representation of the list of dish choices.
     */
    public String showDishesToCook() {
        dishChoices = Kitchen.showDishesChoice();
        StringBuilder sb = new StringBuilder();
        sb.append("Name      Quantity\n");
        for (String dish: dishChoices.keySet()) {
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < 10 - dish.length(); i++){
                space.append(" ");
            }
            sb.append(dish + space + dishChoices.get(dish) + "\n");
        }
        return sb.toString();
    }


    /**
     * Mark the given dish as cooked, and push the ready dish to the Buffer for Delivery staff,
     * and update the inventory. Give a new order to Kitchen if it needs one.
     *
     * @param dishName One of the dish choices provided to Kitchen in showDishToCook.
     */
    public void completeDish(String dishName) {
        // Since more clever design (such as button) will be later implemented. There is no
        // need to check if the given dishName is valid.
        Kitchen.cookedDish(dishName);
        updateInventory(dishName);
        if (Kitchen.needNextOrder()) {
            Kitchen.getNextToCook();
        }
    }


    /**
     * Update the inventory according to the ingredients used in the given dish name.
     * @param dishName The name of the cooked dish
     */
    private void updateInventory(String dishName) {
        // TODO: should this method be in Kitchen use case or controller.
        HashMap<String, Double> ingredientInfo = DishList.getDishIngredients(dishName);

        for (String dish: ingredientInfo.keySet()) {
            double oriQuantity = InventoryList.getTotalQuantity(dish);
            InventoryList.setQuantity(dish, oriQuantity - ingredientInfo.get(dish));
        }
    }
}
