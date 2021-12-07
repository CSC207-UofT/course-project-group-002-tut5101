package use_case.dish_list;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import constant.file_system.FileName;
import entity.order.Dish;
import gateway.GCloudReadWriter;
import gateway.ReadWriter;
import use_case.dish_list.boundaries.ManageMenuOutputBoundary;
import use_case.dish_list.boundaries.MenuOutputBoundary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * Public class storing all dishes information using an ArrayList.
 */
public class DishList implements Serializable, Iterable<Dish> {
    private static HashMap<String, Dish> menu;
    private static final long serialVersionUID = 1L;
    private static final ReadWriter readWriter = new GCloudReadWriter();
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private static String filename = "";
    private MenuOutputBoundary menuOutputBoundary;
    private ManageMenuOutputBoundary manageMenuOutputBoundary;


    /**
     * Constructor of this class
     */
    public DishList() {
        if (menu == null) {
            menu = new HashMap<>();
        }
    }

    /**
     * Reset the dishList for testing
     */
    public void reset() {
        menu = new HashMap<>();
    }

    /**
     * Set output boundary for manage menu.
     *
     * @param manageMenuOutputBoundary output boundary for managing menu.
     */
    public void setManageMenuOutputBoundary(ManageMenuOutputBoundary manageMenuOutputBoundary) {
        this.manageMenuOutputBoundary = manageMenuOutputBoundary;
    }


    /**
     * Return list of dishes
     *
     * @return the menu
     */
    public static HashMap<String, Dish> getAllDishes() {
        return menu;
    }


    /**
     * Get the dish's price for a dish named dishName
     *
     * @param dishName The name of the dish to be checked
     * @return The price of the dish as a double
     */
    public static double getDishPrice(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getPrice();
    }

    /**
     * Get the dish's ingredients of a dish named dishName
     *
     * @param dishName The name of the dish to be look up
     * @return The hashMap representing the ingredients and their amount needed for the dish named dishName
     */
    public static HashMap<String, Integer> getDishIngredients(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getIngredients();
    }

    /**
     * Get the calories of a dish
     *
     * @param dishName Name of the dish
     * @return Calories of the dish as double
     */
    public static double getDishCalories(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getCalories();
    }

    /**
     * Returns an iterator for this dishList.
     *
     * @return an iterator for this dishList.
     */
    @Override
    @NonNull
    public DishListIterator iterator() {
        return new DishListIterator();
    }

    /**
     * Delete a dish from the menu by its name
     *
     * @param dishName the name of the dish to be deleted
     */
    public void deleteDishByName(String dishName) {
        menu.remove(dishName);
        saveToFile();
    }


    /**
     * Edit the dish by its name.
     *
     * @param dishName name of the dish to be edited.
     */
    public void editCalories(String dishName, int i, double j) {
        Dish dish = menu.get(dishName);
        assert dish != null;
        if (i == 0) {
            dish.decreaseCalories(j);
        } else {
            dish.increaseCalories(j);
        }
        menu.put(dishName, dish);
        saveToFile();
    }

    /**
     * Edit the dish by its name.
     *
     * @param dishName name of the dish to be edited.
     */
    public void editPrice(String dishName, int i, double j) {
        Dish dish = menu.get(dishName);
        assert dish != null;
        if (i == 0) {
            dish.decreasePrice(j);
        } else {
            dish.increasePrice(j);
        }
        menu.put(dishName, dish);
        saveToFile();
    }

    /**
     * a list of dish names.
     */
    public void passDishesAsList() {
        Set<String> keySet = menu.keySet();
        manageMenuOutputBoundary.passingDishesAsList(keySet.toArray(new String[0]));
    }

    /**
     * Add Dish to DishList
     *
     * @param dish new dish to be added
     */
    public void addDish(Dish dish) {
        if (menu != null) {
            menu.put(dish.getName(), dish);
            saveToFile();
        }
    }

    /**
     * Override the toString method of Object and return a fine illustration of the DishList information
     *
     * @return a string representation of the list of Dishes
     */

    @Override
    @NonNull
    public String toString() {
        int dishNumber = 1;
        StringBuilder menuString = new StringBuilder();
        for (String dishName : menu.keySet()) {
            menuString.append(dishNumber).append(". ").append(Objects.requireNonNull(menu.get(dishName)));
            dishNumber++;
        }
        return menuString.toString();

    }

    /**
     * Set the menuOutputBoundary of this class
     *
     * @param menuOutputBoundary the menu output boundary
     */
    public void setMenuOutputBoundary(MenuOutputBoundary menuOutputBoundary) {
        this.menuOutputBoundary = menuOutputBoundary;
    }

    /**
     * Update the dishes in the menu
     */
    public void dishesString() {
        menuOutputBoundary.updateMenuItemsDisplay(this.toString());
    }

    public void saveToFile() {
        if (filename != null) {
            readWriter.saveToFile(context, filename, menu);
        }
    }

    /**
     * Setting context.
     *
     * @param context context.
     */
    public static void setContext(Context context) {
        DishList.context = context;
    }

    /**
     * Setting data for menu
     *
     * @param filename the name of the data file
     */
    @SuppressWarnings("unchecked")
    public static void setData(String filename) {
        DishList.filename = filename;
        if (menu == null || menu.isEmpty()) {
            menu = (HashMap<String, Dish>) readWriter.readFromFile(FileName.MENU_FILE);
        }
    }

}
