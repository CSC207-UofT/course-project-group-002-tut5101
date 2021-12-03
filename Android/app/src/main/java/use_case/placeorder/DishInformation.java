package use_case.placeorder;

import entity.orderlist.Dish;
import use_case.customer.PlaceOrderOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Provides information about dishes for presenters
 */
public class DishInformation {
    String[] dishNames;
    private static HashMap<String, Dish> menu;
    private PlaceOrderOutputBoundary placeOrderOutputBoundary;

    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishInformation() {
        menu = new HashMap<>();
        dishNames = menu.keySet().toArray(new String[0]);
    }

    public void setPlaceOrderOutputBoundary(PlaceOrderOutputBoundary placeOrderOutputBoundary) {
        this.placeOrderOutputBoundary = placeOrderOutputBoundary;
    }

    /**
     *
     * updates the number of dishes available to be picked
     */
    public void numberOfDishesForPresenter(){
        int numberOfDishes = menu.size();
        placeOrderOutputBoundary.setDishNamePickerMaxValue(numberOfDishes);
    }


    /**
     *
     * updates the array of dish names to be displayed
     */
    public void getAllDishNamesAsListForPresenter() {
        ArrayList<String> dishNamesAndPrice = new ArrayList<>();
        String nameAndPrice;
        for (String name : dishNames) {
            nameAndPrice = name + "   $" + Objects.requireNonNull(menu.get(name)).getPrice();
            dishNamesAndPrice.add(nameAndPrice);
        }
        placeOrderOutputBoundary.setDisplayedDishNames(dishNamesAndPrice.toArray(new String[0]));
    }
    /**
     *
     * updates the dishes ordered
     * @param dishNameIndex the index of the dish ordered
     * @param dishQuantity the quantity of the dish ordered
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
     * @param dish new dish to be added
     */
    public void addDish(Dish dish) {
        menu.put(dish.getName(), dish);
        dishNames = menu.keySet().toArray(new String[0]);
    }

}
