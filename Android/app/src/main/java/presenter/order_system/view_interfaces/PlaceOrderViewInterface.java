package presenter.order_system.view_interfaces;

import java.util.HashMap;
/**
 * ViewInterface of place order
 */
public interface PlaceOrderViewInterface {
    /**
     * Display the dishes ordered
     * @param displayedText text to display
     */
    void displayDishesOrdered(String[] displayedText);

    /**
     * Set the dishes ordered
     * @param dishesOrdered dishes ordered
     */
    void setDishesOrdered(HashMap<String, Integer> dishesOrdered);

    /**
     * Set the dish prices
     * @param dishPrices dish prices
     */
    void setDishPrices(HashMap<String, Double> dishPrices);


    /**
     * Show the Order successfully placed page
     */
    void orderSuccessfullyPlaced();

    /**
     * Set the error message
     * @param message message to display
     */
    void setErrorMessage(String message);


    /**
     * pass information to the next activity and run the edit order activity
     */
    void runEditOrder();
}
