package presenter.order_system;

import presenter.order_system.view_interfaces.PlaceOrderMenuViewInterface;
import use_case.dish_list.DishInformation;
import use_case.dish_list.DishList;
import use_case.dish_list.boundaries.PlaceOrderMenuOutputBoundary;

/**
 * Presenter class for the PlaceOrder activity that displays information on menu
 */
public class PlaceOrderMenuPresenter implements PlaceOrderMenuOutputBoundary {
    private DishInformation dishInformation;
    private PlaceOrderMenuViewInterface placeOrderMenuViewInterface;

    /**
     * Constructor for this class
     */
    public PlaceOrderMenuPresenter() {

    }

    /**
     * Set the view interface
     * @param placeOrderMenuViewInterface the view interface
     */
    public void setPlaceOrderMenuViewInterface(PlaceOrderMenuViewInterface placeOrderMenuViewInterface) {
        this.placeOrderMenuViewInterface = placeOrderMenuViewInterface;
        initializeDishList();
    }

    /**
     * Initialize the dishList
     */
    private void initializeDishList() {
        new DishList();
        this.dishInformation = new DishInformation();
        dishInformation.setPlaceOrderMenuOutputBoundary(this);
    }

    /**
     * Get number of dishes in menu from DishInformation use case
     */
    public void numberOfDishesInMenu() {
        dishInformation.numberOfDishesForPresenter();
    }

    /**
     * Get names of all dishes from DishInformation use case
     */
    public void allDishNames() {
        dishInformation.getAllDishNamesAsListForPresenter();
    }


    /**
     * set the number of dishes ordered on view
     * @param size the number of dishes
     */
    @Override
    public void setDishNamePickerMaxValue(int size) {
        if (size >= 1) {
            placeOrderMenuViewInterface.setDishNamePickerMaxValue(size);
        }
        else {placeOrderMenuViewInterface.setDishNamePickerMaxValue(0);
        }
    }

    /**
     * set the view to display dishes ordered
     * @param dishNames dishes ordered
     */
    @Override
    public void setDisplayedDishNames(String[] dishNames) {
        placeOrderMenuViewInterface.setDisplayedDishNames(dishNames);
    }


    }
