package use_case.dish_list.boundaries;

/**
 * The output use_case.boundary for PlaceOrderMenu presenter.
 */
public interface PlaceOrderMenuOutputBoundary {
    /**
     * set the number of dishes ordered on view
     *
     * @param size the number of dishes
     */
    void setDishNamePickerMaxValue(int size);

    /**
     * set the view to display dishes ordered
     *
     * @param dishNames dishes ordered
     */
    void setDisplayedDishNames(String[] dishNames);
}
