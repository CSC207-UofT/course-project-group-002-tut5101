package presenter.order_system.view_interfaces;
/**
 * ViewInterface of place order with menu
 */
public interface PlaceOrderMenuViewInterface {
    /**
     * method called from the use case through interface to set the number of dish choices
     * @param size the number of dish choices
     */
    void setDishNamePickerMaxValue(int size);
    /**
     * method called from the use case through interface to set the available dish names
     * @param dishNames the array of all dish names
     */
    void setDisplayedDishNames(String[] dishNames);
}


