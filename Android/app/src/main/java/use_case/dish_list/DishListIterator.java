package use_case.dish_list;

import entity.order.Dish;

import java.util.*;

/**
 * An Iterator for DishList.
 */
public class DishListIterator implements Iterator<Dish> {

    /**
     * The index of the next Dish to return.
     */
    private int current = 0;
    private static HashMap<String, Dish> menu;

    public DishListIterator() {
        menu = DishList.getAllDishes();
    }

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
     * Returns the next Dish.
     *
     * @return the next Dish.
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
     *
     * @param dish The new dish that will replace the dish with the same name in the list
     */
    public void replace(Dish dish) {
        Set<String> keySet = menu.keySet();
        List<String> list = new ArrayList<>(keySet);
        String dishName = list.get(current);
        menu.put(dishName, dish);
    }

}