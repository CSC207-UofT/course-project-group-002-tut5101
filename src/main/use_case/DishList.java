package use_case;

import entity.Dish;

import java.util.HashMap;

/**
 * Public class storing all dishes information using an ArrayList.
 *
 * @author Chan Yu & Naihe Xiao
 */
public class DishList {
    private static HashMap<String, Dish> menu;

    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishList() {
        menu = new HashMap<>();
    }

    public DishList(DishList dishList) {
        menu = dishList.getAllDishes();
    }

    /**
     * Return list of dishes
     *
     * @return
     */
    public static HashMap<String, entity.Dish> getAllDishes() {
        return menu;
    }

    /**
     * //TODO:
     * Return true if the restaurant has enough inventory for the Dish
     * @return true with inventory, or false if out of stock.
     *
     */
    public static boolean hasInventoryOfTheDish() {
        return false;
    }

    /**
     * Override the toString method of Object and return a fine illustration of the DishList information
     *
     * @return a string representation of the list of Dishes
     */
    @Override
    public String toString() {
        int dishNumber = 1;
        StringBuilder menuString = new StringBuilder();
        for (String dishName : menu.keySet()) {
            menuString.append(dishNumber + ". " + menu.get(dishName).toString());
            dishNumber++;
        }
        return menuString.toString();
    }
}
