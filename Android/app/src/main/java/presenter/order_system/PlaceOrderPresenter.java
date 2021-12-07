package presenter.order_system;

import constant.order_system.OrderType;
import presenter.order_system.view_interfaces.PlaceOrderViewInterface;
import use_case.dish_list.DishInformation;
import use_case.dish_list.DishList;
import use_case.placeorder.PlaceOrder;
import use_case.placeorder.boundaries.PlaceOrderInputBoundary;
import use_case.placeorder.boundaries.PlaceOrderOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * This is the Order presenter corresponding to the PlaceOrderActivity, that takes input from the activity, does stuff,
 * then tells the activity what to show to the user
 * by Evelyn Chou
 * 2021-11-03
 */

public class PlaceOrderPresenter implements PlaceOrderOutputBoundary {

    private HashMap<String, Integer> dishesOrdered;
    private HashMap<String, Double> dishPrices;
    private DishInformation dishInformation;

    /**
     * The input use_case.boundary for the place order.
     */
    private final PlaceOrderInputBoundary placeOrderInputBoundary;
    private PlaceOrderViewInterface placeOrderViewInterface;

    /**
     * A new OrderController for the use case defined by the PlaceOrderInputBoundary.
     */
    public PlaceOrderPresenter() {
        this.dishesOrdered = new HashMap<>();

        this.placeOrderInputBoundary = new PlaceOrder();

    }

    // called from activity
    /**
     * get the current ordered dishes
     * @param dishesOrdered dishes ordered
     */
    public void setDishesOrdered(HashMap<String, Integer> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    /**
     * Set the dish prices
     * @param dishPrices hashmap of dish name referring to price
     */
    public void setDishPrices(HashMap<String, Double> dishPrices) {
        this.dishPrices = dishPrices;
    }


    /**
     * Decide if the edit order activity should be shown on the view
     */
    public void checkRunEditOrder() {
        if (!dishesOrdered.isEmpty()) {
            placeOrderViewInterface.runEditOrder();
        }
        else {
            placeOrderViewInterface.setErrorMessage("No Dishes Ordered");
        }
    }

    /**
     * set the PlaceOrderViewInterface attribute
     * @param placeOrderViewInterface the PlaceOrderViewInterface
     */
    public void setPlaceOrderViewInterface(PlaceOrderViewInterface placeOrderViewInterface) {
        this.placeOrderViewInterface = placeOrderViewInterface;
        initializeDishList();
    }

    /**
     * Initialize the dishList
     */
    private void initializeDishList() {
        new DishList();
        this.dishInformation = new DishInformation();
        dishInformation.setPlaceOrderOutputBoundary(this);
    }

    // Updates information in the activity

    /**
     * update the ordered dishes in the view
     */
    public void updateDishesOrderedInView() {
        placeOrderViewInterface.setDishesOrdered(dishesOrdered);
    }

    /**
     * update the dish prices in the view
     */
    public void updateDishPrices() {
        placeOrderViewInterface.setDishPrices(dishPrices);
    }


    // calls use case DishInformation (called from activity)

    /**
     * pass the index of the dish ordered and the quantity ordered to the dishInformation
     * @param dishNameIndex index referring to dish ordered
     * @param dishQuantity quantity ordered
     */
    public void passDishesOrdered(int dishNameIndex, int dishQuantity) {
        dishInformation.passDishesOrdered(dishNameIndex, dishQuantity);
    }


    /**
     * Add a dish price to the dishPrices hashmap
     * @param dishName name of dish
     * @param price price of dish
     */
    public void addDishPrices(String dishName, double price) {
        dishPrices.put(dishName, price);
    }



    /**
     * method called from the use case through interface to update the list of dishes ordered
     * @param dishName     the name of dish ordered
     * @param dishQuantity the quantity of dish ordered
     */
    public void updateDishesOrdered(String dishName, int dishQuantity) {
        if (dishesOrdered.containsKey(dishName)) {
            Integer quantity = dishesOrdered.get(dishName);
            if (quantity != null) {
                dishQuantity = quantity + dishQuantity;
            }
        }
        else {
            getDishPrices(dishName);
        }
        dishesOrdered.remove(dishName);
        dishesOrdered.put(dishName, dishQuantity);
        displayDishesOrdered();
    }

    /**
     * get dish price from dishList
     * @param dishName name of dish to get price for
     */
    private void getDishPrices(String dishName) {
        dishInformation.dishPrice(dishName);
    }


    /**
     * Collect all the dishes ordered and their prices and tell the view to display them
     */
    public void displayDishesOrdered() {

        ArrayList<String> dishesString = new ArrayList<>();
        double totalPrice = 0;

        for (String dishName : dishesOrdered.keySet()) {
            totalPrice = getPriceAndAddStringToArrayList(dishesString, totalPrice, dishName);
        }
        totalPrice = (totalPrice / 100);

        String s = String.format(Locale.CANADA, "%.2f", totalPrice);
        String totalPriceText = "\n\nTOTAL PRICE: $" + s;
        dishesString.add(totalPriceText);
        placeOrderViewInterface.displayDishesOrdered(dishesString.toArray(new String[0]));
    }

    /**
     * Helper method to get price and string representation needed for display
     * @param dishesString the ArrayList of dishes string representations to mutate
     * @param totalPrice the current total price before this dish
     * @param dishName the current dish name
     * @return the new total price
     */
    private double getPriceAndAddStringToArrayList(ArrayList<String> dishesString, double totalPrice, String dishName) {
        Integer tempQuantity = dishesOrdered.get(dishName);
        Double tempPrice = dishPrices.get(dishName);

        if (tempQuantity != null && tempPrice != null){
            int quantity = tempQuantity;
            double price = tempPrice;
            String p = String.format(Locale.CANADA, "%.2f", price);

            dishesString.add(dishName + " x " + quantity + "   $" +
                    p + "\t each");

            for (int i = 1; i <= quantity; i++) {
                totalPrice += price * 100;
            }
        }
        return totalPrice;
    }


    // calls use case PlaceOrder

    /**
     * Try placing order.
     * If successful, tell view to show success screen
     * If unsuccessful, tell view to display error message
     * @param orderType the object where information is stored
     * @param location the table number if dine in, otherwise the address for the order to be delivered
     */
    public void runPlaceOrderInformation(OrderType orderType, String location) {
            String [] dishes = collectDishes();

            try {
                placeOrderInputBoundary.placeOrder(orderType, dishes, location);
                placeOrderViewInterface.orderSuccessfullyPlaced();
            }
            catch (Exception e) {
                String message = "Error, please try again";
                placeOrderViewInterface.setErrorMessage(message);
            }
        }

    /**
     * Collect array representation of dish names
     * @return the array of dish names
     */
    private String[] collectDishes() {
        ArrayList<String> collectDishes = new ArrayList<>();
        for (String dishName : dishesOrdered.keySet()) {
            int count = 1;
            Integer quantity = dishesOrdered.get(dishName);
            if (quantity != null) {
                while (count <= quantity) {
                    collectDishes.add(dishName);
                    count += 1;
                }
            }
        }
        return collectDishes.toArray(new String[0]);
    }


}

