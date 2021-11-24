package use_case.dishList;

import android.annotation.SuppressLint;
import constant.fileSystem.FileLocation;
import entity.orderList.Dish;
import gateway.ReadWriter;
import gateway.SerReadWriter;

import java.io.Serializable;
import java.util.*;

/**
 * Public class storing all dishes information using an ArrayList.
 *
 * @author Chan Yu & Naihe Xiao
 */
public class DishList implements Serializable, Iterable<Dish> {
    private static HashMap<String, Dish> menu;
    private static HashMap<Integer, String> keySet = new HashMap<>();
    private static final long serialVersionUID = 1L;
    ReadWriter readWriter;
    private String filepath = FileLocation.MENU_FILE_LOCATION;


    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishList() {
        readWriter = new SerReadWriter();
        menu = readWriter.readFromFile(filepath);
    }

    public DishList(String filepath) {
        this.filepath = filepath;
        readWriter = new SerReadWriter();
        menu = readWriter.readFromFile(filepath);
    }


    /**
     * This constructor constructs dishList from a list of dishes
     * @param dishes The list of dishes to create the dishList
     */
    public DishList(List<Dish> dishes) {
        menu = new HashMap<>();
        for (Dish d : dishes) {
            menu.put(d.getName(), d);
        }
    }



    /**
     * Return list of dishes
     *
     * @return the menu
     */
    public Map getAllDishes() {
        return menu;
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
        keySet = new HashMap<>();
        for (String dishName : menu.keySet()) {
            menuString.append(dishNumber).append(". ").append(Objects.requireNonNull(menu.get(dishName)));
            keySet.put(dishNumber, Objects.requireNonNull(menu.get(dishName)).getName());
            dishNumber++;
        }
        return menuString.toString();

    }
    // Methods that allow lookup dish information without returning the dish itself

    /**
     * Get the dish's price for a dish named dishName
     * @param dishName The name of the dish to be checked
     * @return The price of the dish as a double
     */
    public static double getDishPrice(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getPrice();
    }

    /**
     * Get the dish's ingredients of a dish named dishName
     * @param dishName The name of the dish to be look up
     * @return The hashMap representing the ingredients and their amount needed for the dish named dishName
     */
    public static HashMap<String, Double> getDishIngredients(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getIngredients();
    }

    /**
     * Get the calories of a dish
     * @param dishName Name of the dish
     * @return Calories of the dish as double
     */
    public static double getDishCalories(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getCalories();
    }


    /**
     * Get the category of a dish
     * @param dishName The name of the dish
     * @return The category of the dish as string
     */
    public static String getDishCategory(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getCategory();
    }

    /**
     * Return the size of the menu (how many dishes in the menu)
     * @return The number of dishes in the menu
     */
    public int size() {
        return menu.size();
    }

    /**
     * Get the dishNames from integer(index)
     * @param orderedNum The dish numbered in the arrayList data structure to store
     * @return The dish
     */
    public static List<String> getDishNamesFromInt(List<Integer> orderedNum) {
        List<String> dishes = new ArrayList<>();
        for (int num : orderedNum) {
            dishes.add(keySet.get(num));
        }
        return dishes;
    }

    /**
     * Returns an iterator for this dishList.
     *
     * @return an iterator for this dishList.
     */
    @Override
    public Iterator<Dish> iterator() {
        return new DishListIterator();
    }

    /**
     * An Iterator for DishList.
     */
    public static class DishListIterator implements Iterator<Dish> {

        /**
         * The index of the next Dish to return.
         */
        private int current = 0;

        /**
         * Returns whether there is another Dish to return.
         *
         * @return whether there is another Dish to return.
         */
        @Override
        public boolean hasNext() {
            return current < menu.size();
        }

        /**
         * Returns the next Contact.
         *
         * @return the next Contact.
         */
        @Override
        public Dish next() {
            Dish dish;
            try {
                Set<String> keySet = menu.keySet();
                List<String> list = new ArrayList<>(keySet);
                String dishName = list.get(current);
                dish = menu.get(dishName);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            current += 1;
            return dish;
        }

        /**
         * Replace a dish in the dishList using the new dish
         * @param dish The new dish that will replace the dish with the same name in the list
         */
        public void replace(Dish dish) {
            Set<String> keySet = menu.keySet();
            List<String> list = new ArrayList<>(keySet);
            String dishName = list.get(current);
            menu.put(dishName, dish);
        }

    }

    /**
     * Add Dish to DishList
     * @param dish new dish to be added
     */
    public void addDish(Dish dish) {
        menu.put(dish.getName(), dish);
    }

    /**
     * Get Dish by dish name
     * @param dishName name of the dish
     * @return the Dish object
     */
    public Dish getDishByDishName(String dishName) {
        return menu.get(dishName);
    }

    public void saveToFile(){
        readWriter.saveToFile(this.filepath, this.menu);
    }


}
