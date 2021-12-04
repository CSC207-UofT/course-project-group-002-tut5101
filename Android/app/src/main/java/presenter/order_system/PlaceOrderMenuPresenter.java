package presenter.order_system;

import entity.order_list.Dish;
import use_case.dish_list.DishInformation;
import use_case.placeorder.PlaceOrderMenuOutputBoundary;

import java.util.HashMap;

/**
 * Presenter class for the PlaceOrder activity that displays information on menu
 */
public class PlaceOrderMenuPresenter implements PlaceOrderMenuOutputBoundary {
    private final DishInformation dishInformation;
    private PlaceOrderMenuViewInterface placeOrderMenuViewInterface;

    /**
     * Constructor for this class
     */
    public PlaceOrderMenuPresenter( ) {
        this.dishInformation = new DishInformation();
        dishInformation.setPlaceOrderMenuOutputBoundary(this);

        //TODO: Delete later
        generateDishList();
    }

    /**
     * Set the view interface
     * @param placeOrderMenuViewInterface the view interface
     */
    public void setPlaceOrderMenuViewInterface(PlaceOrderMenuViewInterface placeOrderMenuViewInterface) {
        this.placeOrderMenuViewInterface = placeOrderMenuViewInterface;
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


    private void generateDishList() {
        Dish d1 = new Dish("dish1", 10, new HashMap<>(), 20);
        Dish d2 = new Dish("dish2", 30, new HashMap<>(), 200);
        Dish d3 = new Dish("dish3", 100, new HashMap<>(), 10);
        Dish d4 = new Dish("dish4", 10, new HashMap<>(), 20);
        Dish d5 = new Dish("dish5", 10, new HashMap<>(), 20);
        Dish d6 = new Dish("dish6", 10, new HashMap<>(), 20);
        Dish d7 = new Dish("dish7", 10, new HashMap<>(), 20);
        dishInformation.addDish(d1);
        dishInformation.addDish(d2);
        dishInformation.addDish(d3);
        dishInformation.addDish(d4);
        dishInformation.addDish(d5);
        dishInformation.addDish(d6);
        dishInformation.addDish(d7);
    }

    }
