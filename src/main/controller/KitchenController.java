package controller;

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
        Kitchen.cookedDish(dishChoices.get(Integer.parseInt(number)));
        // TODO: update inventory here.
    }
}
