package use_case;

import entity.Dish;

import java.util.HashMap;

/**
 * Public class storing all dishes information using an ArrayList.
 *
 * @author Chan Yu & Naihe Xiao
 */
public class DishList {
    private HashMap<String, Dish> menu;

    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishList() {
        this.menu = new HashMap<>();
    }

    public DishList(DishList dishList) {
        this.menu = dishList.getDishes();
    }


    /**
     * Return list of dishes
     *
     * @return
     */
    public HashMap<String, entity.Dish> getDishes() {
        return this.menu;
    }

    /**
     * //TODO
     * Return true if the restaurant has enough inventory for the Dish
     * @return true with inventory, or false if out of stock.
     *
     */
    public boolean hasInventoryOfTheDish() {
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
