package controller;

import use_case.DishList;
import use_case.InventoryList;
import use_case.Kitchen;

import java.util.HashMap;

public class KitchenController {
    HashMap<Integer, String> dishChoices;

    public String displayOrder() {
        Kitchen.getNextToCook();
        return Kitchen.showOrder();
    }

    public String showDishesToCook() {
        dishChoices = Kitchen.showDishesChoice();
        StringBuilder sb = new StringBuilder();

        for (int i: dishChoices.keySet()){
            sb.append(i + ". " + dishChoices.get(i));
        }

        return sb.toString();
    }

    public void completeDish(String number) {
        String dishName = dishChoices.get(Integer.parseInt(number));
        Kitchen.cookedDish(dishName);
        HashMap<String, Double> ingredientInfo = DishList.getDishIngredients(dishName);

        for (String dish: ingredientInfo.keySet()) {
            for (String ingredient: ingredientInfo.keySet()){
                double oriQuantity = InventoryList.getTotalQuantity(dish);
                InventoryList.setQuantity(dish, oriQuantity - ingredientInfo.get(ingredient));
            }
        }

    }
}
