package use_case.dishList;

import entity.orderList.Dish;

import java.io.Serializable;
import java.util.*;

/**
 * Public class storing all dishes information using an ArrayList.
 *
 * @author Chan Yu & Naihe Xiao
 */
public class DishList implements Serializable, Iterable<Dish> {
    private static Map<String, Dish> menu = new HashMap<>();
    private static HashMap<Integer, String> keySet = new HashMap<>();
    private static final long serialVersionUID = 1L;


    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishList() {
        menu = new HashMap<>();
    }

    /**
     * This constructor is using hash map to initialize dishList
     * @param map hash map type of dishList
     */
    public DishList(HashMap map) {
        menu = map;
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
     * Load a whole hash map
     * @param hashMap Thehash map to be loaded to menu
     */
    public void loadHashMap(HashMap hashMap){
        if(menu.isEmpty()){
            menu.putAll(hashMap);
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
        keySet = new HashMap<Integer, String>();
        for (String dishName : menu.keySet()) {
            menuString.append(dishNumber + ". " + menu.get(dishName).toString());
            keySet.put(dishNumber, menu.get(dishName).getName());
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
        return menu.get(dishName).getPrice();
    }

    /**
     * Get the dish's ingredients of a dish named dishName
     * @param dishName The name of the dish to be look up
     * @return The hashMap representing the ingredients and their amount needed for the dish named dishName
     */
    public static HashMap<java.lang.String, java.lang.Double> getDishIngredients(String dishName) {
        return menu.get(dishName).getIngredients();
    }

    /**
     * Get the calories of a dish
     * @param dishName Name of the dish
     * @return Calories of the dish as double
     */
    public static double getDishCalories(String dishName) {
        return menu.get(dishName).getCalories();
    }


    /**
     * Get the category of a dish
     * @param dishName The name of the dish
     * @return The category of the dish as string
     */
    public static String getDishCategory(String dishName) {
        return menu.get(dishName).getCategory();
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
        List<String> dishes = new ArrayList<String>();
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
    public class DishListIterator implements Iterator<Dish> {

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



}
