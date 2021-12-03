package use_case.dishlist;

import entity.orderlist.Dish;
import use_case.boundary.output.ManageMenuOutputBoundary;
import use_case.boundary.output.MenuOutputBoundary;
import use_case.customer.PlaceOrderOutputBoundary;

import java.io.Serializable;
import java.util.*;

/**
 * Public class storing all dishes information using an ArrayList.
 *
 * @author Chan Yu & Naihe Xiao
 */
public class DishList implements Serializable, Iterable<Dish> {
    private static HashMap<String, Dish> menu;
    private static final long serialVersionUID = 1L;
    String[] dishNames;
    private PlaceOrderOutputBoundary placeOrderOutputBoundary;
    private MenuOutputBoundary menuOutputBoundary;
    private ManageMenuOutputBoundary manageMenuOutputBoundary;


    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishList() {
        menu = new HashMap<>();
        dishNames = menu.keySet().toArray(new String[0]);
    }

    /**
     *
     * @param placeOrderOutputBoundary output boundary for placing order.
     */
    public void setPlaceOrderOutputBoundary(PlaceOrderOutputBoundary placeOrderOutputBoundary) {
        this.placeOrderOutputBoundary = placeOrderOutputBoundary;
    }

    /**
     *
     * @param manageMenuOutputBoundary output boundary for managing menu.
     */
    public void setManageMenuOutputBoundary(ManageMenuOutputBoundary manageMenuOutputBoundary) {
        this.manageMenuOutputBoundary = manageMenuOutputBoundary;
    }

    /**
     *
     * @param menuOutputBoundary output boundary for menu.
     */
    public void setMenuOutputBoundary(MenuOutputBoundary menuOutputBoundary) {
        this.menuOutputBoundary = menuOutputBoundary;
    }

    /**
     * This constructor constructs dishList from a list of dishes
     * @param dishes The list of dishes to create the dishList
     */
    public DishList(List<Dish> dishes) {
        menu = new HashMap<>();
        for (Dish d : dishes) {
            menu.put(d.getName(), d);
        }
    }

    /**
     * Return list of dishes
     *
     * @return the menu
     */
    public static HashMap<String, Dish> getAllDishes() {
        return menu;
    }


    /**
     * Override the toString method of Object and return a fine illustration of the DishList information
     *
     * @return a string representation of the list of Dishes
     */

    @Override
    public String toString() {
        int dishNumber = 1;
        StringBuilder menuString = new StringBuilder();
        for (String dishName : menu.keySet()) {
            menuString.append(dishNumber).append(". ").append(Objects.requireNonNull(menu.get(dishName)));
            dishNumber++;
        }
        return menuString.toString();

    }

    /**
     * Get the dish's price for a dish named dishName
     * @param dishName The name of the dish to be checked
     * @return The price of the dish as a double
     */
    public static double getDishPrice(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getPrice();
    }

    /**
     * Get the dish's ingredients of a dish named dishName
     * @param dishName The name of the dish to be look up
     * @return The hashMap representing the ingredients and their amount needed for the dish named dishName
     */
    public static HashMap<String, Integer> getDishIngredients(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getIngredients();
    }

    /**
     * Get the calories of a dish
     * @param dishName Name of the dish
     * @return Calories of the dish as double
     */
    public static double getDishCalories(String dishName) {
        return Objects.requireNonNull(menu.get(dishName)).getCalories();
    }

    /**
     * Returns an iterator for this dishList.
     *
     * @return an iterator for this dishList.
     */
    @Override
    public DishListIterator iterator() {
        return new DishListIterator();
    }

    /**
     * Delete the dish by its name.
     *
     * @param dishName name of the dish to be deleted.
     */
    public void deleteDishByName(String dishName) {
        menu.remove(dishName);
    }


    /**
     * Edit the dish by its name.
     *
     * @param dishName name of the dish to be edited.
     */
    public void editDishByName(String dishName) {
        Dish dish = menu.get(dishName);
        assert dish != null;
        dish.increasePrice();
        dish.decreaseCalories();
    }

    /**
     *
     * a list of dish names.
     */
    public void passDishesAsList() {
        Set<String> keySet = menu.keySet();
        manageMenuOutputBoundary.passingDishesAsList(keySet.toArray(new String[0]));
    }

    /**
     * Add Dish to DishList
     * @param dish new dish to be added
     */
    public void addDish(Dish dish) {
        menu.put(dish.getName(), dish);
        dishNames = menu.keySet().toArray(new String[0]);
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


    public void dishesString() {
        menuOutputBoundary.updateMenuItemsDisplay(this.toString());
    }

    public void dishPrice(String dishName) {
        double price = Objects.requireNonNull(menu.get(dishName)).getPrice();
        placeOrderOutputBoundary.addDishPrices(dishName, price);
    }

}
