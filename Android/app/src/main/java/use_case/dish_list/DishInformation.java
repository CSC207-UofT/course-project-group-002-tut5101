package use_case.dish_list;

import entity.order.Dish;
import use_case.dish_list.boundaries.PlaceOrderMenuOutputBoundary;
import use_case.placeorder.boundaries.PlaceOrderOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Provides information about dishes for presenters
 */
public class DishInformation {
    private String[] dishNames;
    private static HashMap<String, Dish> menu;
    private PlaceOrderOutputBoundary placeOrderOutputBoundary;
    private PlaceOrderMenuOutputBoundary placeOrderMenuOutputBoundary;

    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishInformation() {
        if (DishList.getAllDishes() != null) {
            menu = DishList.getAllDishes();
        } else {
            menu = new HashMap<>();
        }
        dishNames = menu.keySet().toArray(new String[0]);
    }

    /**
     * Constructor for constructing a null object for test
     */
    public DishInformation(int k) {
        menu = new HashMap<>();
        ArrayList<String> dishes = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            dishes.add("1");
        }
        assert dishes.size() == k;
    }


    /**
     * Set the output boundary for displaying menu for place order
     *
     * @param placeOrderMenuPresenter the output boundary
     */
    public void setPlaceOrderMenuOutputBoundary(PlaceOrderMenuOutputBoundary placeOrderMenuPresenter) {
        this.placeOrderMenuOutputBoundary = placeOrderMenuPresenter;
    }

    /**
     * updates the number of dishes available to be picked
     */
    public void numberOfDishesForPresenter() {
        int numberOfDishes = menu.size();
        placeOrderMenuOutputBoundary.setDishNamePickerMaxValue(numberOfDishes);
    }


    /**
     * updates the array of dish names to be displayed
     */
    public void getAllDishNamesAsListForPresenter() {
        ArrayList<String> dishNamesAndPrice = new ArrayList<>();
        String nameAndPrice;
        for (String name : dishNames) {
            nameAndPrice = name + "   $" + Objects.requireNonNull(menu.get(name)).getPrice();
            dishNamesAndPrice.add(nameAndPrice);
        }
        placeOrderMenuOutputBoundary.setDisplayedDishNames(dishNamesAndPrice.toArray(new String[0]));
    }

    /**
     * Set the place order output boundary
     *
     * @param placeOrderOutputBoundary the output boundary
     */
    public void setPlaceOrderOutputBoundary(PlaceOrderOutputBoundary placeOrderOutputBoundary) {
        this.placeOrderOutputBoundary = placeOrderOutputBoundary;
    }

    /**
     * updates the dishes ordered
     *
     * @param dishNameIndex the index of the dish ordered
     * @param dishQuantity  the quantity of the dish ordered
     */
    public void passDishesOrdered(int dishNameIndex, int dishQuantity) {
        String dishName = dishNames[dishNameIndex];
        placeOrderOutputBoundary.updateDishesOrdered(dishName, dishQuantity);
    }


    public void dishPrice(String dishName) {
        double price = Objects.requireNonNull(menu.get(dishName)).getPrice();
        placeOrderOutputBoundary.addDishPrices(dishName, price);
    }

    /**
     * Add Dish to DishList
     *
     * @param dish new dish to be added
     */
    public void addDish(Dish dish) {
        menu.put(dish.getName(), dish);
        dishNames = menu.keySet().toArray(new String[0]);
    }
}
