package presenter.kitchen_system;

import android.content.Context;
import use_case.dish_list.DishList;
import use_case.kitchen.InventoryList;
import use_case.kitchen.Kitchen;
import use_case.kitchen.KitchenOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

public class KitchenPresenter implements KitchenOutputBoundary {
    private KitchenView kv;
    private Kitchen kitchen;
    private HashMap<String, Integer> dishes;
    private InventoryList inventory;


    // TODO: to be deleted when the menu is initialized automatically
    private DishList dl;

    public KitchenPresenter(KitchenView kv) {
        this.kitchen = new Kitchen(this);
        this.kv = kv;

        // TODO: to be deleted
        this.dl = new DishList("menu.ser", (Context) kv);
        this.inventory = new InventoryList("inventory.ser", (Context) kv);
    }

    /**
     * @return dishes as list of size 2 string array, each being the name of the dish and
     * the quantity of the dish.
     */
    public ArrayList<String[]> exportDishes() {
        ArrayList<String[]> displayDishes = new ArrayList<>();

        if (dishes != null) {
            for (String a : dishes.keySet()) {
                displayDishes.add(new String[]{a, String.valueOf(dishes.get(a))});
            }
        }
        return displayDishes;
    }

    public void setInventory(InventoryList inventory){
        this.inventory = inventory;
    }


    @Override
    public void getNextOrder(HashMap<String, Integer> dishes){
        this.dishes = dishes;
    }

    public void checkOrderAvailable() {
        this.kitchen.getAvailableOrder();
    }

    /**
     * Display the ingredients for a given dish.
     * @param dishName The name of the dish whose ingredients will be displayed.
     * @return A string representation of the ingredients.
     */
    public String displayIngredient(String dishName) {
        HashMap<String, Integer> in = DishList.getDishIngredients(dishName);
        StringBuilder sb = new StringBuilder();
        sb.append(dishName).append("\n").append("# Ingredient ---- Quantity #\n");
        for (String ingreName: in.keySet()) {
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < 16 - ingreName.length(); i++){
                space.append(" ");
            }
            sb.append("# ").append(ingreName).append(space).append(in.get(ingreName)).append("\n");
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
     * @param dishName One of the dish choices provided to Kitchen in showDishToCook.
     * @return whether all dish in dishes is cooked.
     */
    public boolean completeDish(String dishName) {
        this.kitchen.cookedDish(dishName);
        updateInventory(dishName);
        Integer name = dishes.get(dishName);
        if (name != null){
            if (name > 1) {
                dishes.put(dishName, name - 1);
            } else {
                dishes.remove(dishName);
            }
        }
        return 0 == dishes.size();
    }


    /**
     * Update the inventory according to the ingredients used in the given dish name.
     * @param dishName The name of the cooked dish
     */
    private void updateInventory(String dishName) {
        HashMap<String, Integer> ingredientInfo = DishList.getDishIngredients(dishName);

        for (String dish: ingredientInfo.keySet()) {
            int oriQuantity = InventoryList.getTotalQuantity(dish);
            int temp = ingredientInfo.get(dish);
            if (temp != 0){
                this.inventory.setQuantity(dish, oriQuantity - temp);
            }
            oriQuantity = InventoryList.getTotalQuantity(dish);
            this.inventory.setQuantity(dish, oriQuantity - ingredientInfo.get(dish));
        }
    }

}
