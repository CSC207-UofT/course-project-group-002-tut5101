package use_case.placeorder.boundaries;

/**
 * The output boundary for Place order presenter.
 */
public interface PlaceOrderOutputBoundary {
    /**
     * method called from the use case through interface to update the list of dishes ordered
     *
     * @param dishName     the name of dish ordered
     * @param dishQuantity the quantity of dish ordered
     */
    void updateDishesOrdered(String dishName, int dishQuantity);

    /**
     * Add a dish price to the dishPrices hashmap
     *
     * @param dishName name of dish
     * @param price    price of dish
     */
    void addDishPrices(String dishName, double price);
}
