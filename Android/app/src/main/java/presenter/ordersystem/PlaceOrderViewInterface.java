package presenter.ordersystem;

import java.util.HashMap;

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
     *
     */
    void runEditOrder();
}
