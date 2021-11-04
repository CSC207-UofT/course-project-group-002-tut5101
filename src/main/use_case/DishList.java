package use_case;

import entity.Dish;

import java.io.Serializable;
import java.util.*;

/**
 * Public class storing all dishes information using an ArrayList.
 *
 * @author Chan Yu & Naihe Xiao
 */
public class DishList implements Serializable, Iterable<Dish>{
    private static HashMap<String, Dish> menu;

    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */

    // TODO: delete later if needed
    public DishList() {
        menu = DishList.getAllDishes();
    }

    public DishList(List<Dish> dishes){
        menu = new HashMap<>();
        for (Dish d: dishes){
            menu.put(d.getName(), d);
        }
    }

    /**
     * Return list of dishes
     *
     * @return the menu
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
    // Methods that allow lookup dish information without returning the dish itself

    public static double getDishPrice(String dishName) {
        // TODO: handle dish name not in menu case
        return menu.get(dishName).getPrice();
    }

    public static HashMap<java.lang.String, java.lang.Double> getDishIngredients(String dishName) {
        return menu.get(dishName).getIngredients();
    }

    public static double getDishCalories(String dishName) {
        return menu.get(dishName).getCalories();
    }

    // TODO: Add additional methods to get other dish info such as allergy information

    public static String getDishCategory(String dishName) {
        return menu.get(dishName).getCategory();
    }

    public int size() {
        return this.size();
    }

    /**
     * Returns an iterator for this address book.
     *
     * @return an iterator for this address book.
     */
    @Override
    public Iterator<Dish> iterator() {
        return new DishListIterator();
    }

    /**
     * An Iterator for DishList.
     */
    private class DishListIterator implements Iterator<Dish>{

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
//
//        public void replace(Dish dish){
//            Set<String> keySet = menu.keySet();
//            List<String> list = new ArrayList<>(keySet);
//            String dishName = list.get(current);
//            menu.put(dishName, dish);
//        }

    }
}
