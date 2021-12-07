package presenter.order_system.view_interfaces;

import java.util.HashMap;
/**
 * ViewInterface of edit order
 */
public interface EditOrderViewInterface {
    /**
     * Display the ordered dishes
     * @param dishesOrderedList dishes ordered
     */
    void displayDishesOrdered(String[] dishesOrderedList);
    /**
     * Set the number of options to pick from
     * @param numDishes number of options
     */
    void setOrderedDishesPickerMax(int numDishes);
    /**
     * Set the ordered dishes options to edit
     * @param dishes dishes ordered
     */
    void setOrderedDishesPickerValues(String[] dishes);
    /**
     * Update the dishes ordered
     * @param dishesOrdered the new dishes ordered
     */
    void updateDishesOrdered(HashMap<String, Integer> dishesOrdered);
}
