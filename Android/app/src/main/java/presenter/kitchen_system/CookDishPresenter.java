package presenter.kitchen_system;

import use_case.dish_list.DishList;
import use_case.inventory.InventoryList;
import use_case.kitchen.CookDish;
import use_case.kitchen.boundary.KitchenOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Presenter class for kitchen
 */
public class CookDishPresenter implements KitchenOutputBoundary {
    private CookDishView kv;
    private final CookDish kitchen;
    private static HashMap<String, Integer> dishes;
    private final InventoryList inventory;


    /**
     * Empty constructor
     */
    public CookDishPresenter() {
        this.kitchen = new CookDish(this);
        this.inventory = new InventoryList();
    }


    /**
     * Set the view that the KitchenPresenter is interacting with
     * @param kv the activity implementing KitchenView
     */
    public void setView(CookDishView kv) {
        this.kv = kv;
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

    /**
     * Update the current dishes to be the potentially new orders.
     * @param dishes the new dishes (order) to be cooked
     */
    @Override
    public void getNextOrder(HashMap<String, Integer> dishes){
        CookDishPresenter.dishes = dishes;
    }

    /**
     * Check if a new order is available and should be used to replace the current one
     */
    public boolean checkOrderAvailable() {
        return this.kitchen.getAvailableOrder();
    }

    /**
     * Mark the given dish as cooked.
     * Update the inventory.
     *
     * If the given dish is all completed in dishes, remove this element from dishes. Otherwise,
     * decreases the quantity of this dish by 1.
     *
     * @param dishName One of the dish choices provided to Kitchen in showDishToCook.
     */
    public void completeDish(String dishName) {
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
    }


    /**
     * Update the view in activity and prompt messages
     * @param dishName The name of the dish that is completed.
     */
    public void updateView(String dishName) {
        kv.createToast("One " + dishName + " cooked", true);
        if (0 == dishes.size() && checkOrderAvailable()) {
            kv.createToast("NEW ORDER!", false);
        }
        kv.renewDishes(exportDishes());
        kv.updateListDisplay();
    }

    /**
     * Update the inventory according to the ingredients used in the given dish name.
     * @param dishName The name of the cooked dish
     */
    private void updateInventory(String dishName) {
        HashMap<String, Integer> ingredientInfo = DishList.getDishIngredients(dishName);

        for (String dish: ingredientInfo.keySet()) {
            int oriQuantity = InventoryList.getTotalQuantity(dish);
            Integer dishIngredientInfo = ingredientInfo.get(dish);
            if (dishIngredientInfo != null) {
                int temp = dishIngredientInfo;
                if (temp != 0) {
                    this.inventory.setQuantity(dish, oriQuantity - temp);
                }
                oriQuantity = InventoryList.getTotalQuantity(dish);
                this.inventory.setQuantity(dish, oriQuantity - temp);
            }
        }
    }

}
