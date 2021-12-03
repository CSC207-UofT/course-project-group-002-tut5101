package presenter.customersystem;

import constant.ordersystem.OrderType;
import entity.orderlist.Dish;
import use_case.boundary.input.PlaceOrderInputBoundary;
import use_case.placeorder.DishInformation;
import use_case.placeorder.PlaceOrder;
import use_case.placeorder.PlaceOrderOutputBoundary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the Order presenter corresponding to the PlaceOrderActivity, that takes input from the activity, does stuff,
 * then tells the activity what to show to the user
 * by Evelyn Chou
 * 2021-11-03
 */

public class PlaceOrderPresenter implements PlaceOrderOutputBoundary{

    private HashMap<String, Integer> dishesOrdered;
    private HashMap<String, Double> dishPrices;
    private final DishInformation dishInformation;

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

        this.dishInformation = new DishInformation();
        dishInformation.setPlaceOrderOutputBoundary(this);

        //TODO: Delete later
        generateDishList();

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
    }

    // Updates information in the activity

    /**
     * update the ordered dishes in the view
     */
    public void updateDishesOrdered() {
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
     * pass the index of the dish ordered and the quantity ordered to the dishInformation
     * @param dishNameIndex index referring to dish ordered
     * @param dishQuantity quantity ordered
     */
    public void passDishesOrdered(int dishNameIndex, int dishQuantity) {
        dishInformation.passDishesOrdered(dishNameIndex, dishQuantity);
    }


    // called from use case dishInformation

    /**
     * set the number of dishes ordered on view
     * @param size the number of dishes
     */
    @Override
    public void setDishNamePickerMaxValue(int size) {
        if (size >= 1) {
            placeOrderViewInterface.setDishNamePickerMaxValue(size);
        }
        else {placeOrderViewInterface.setDishNamePickerMaxValue(0);
        }
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
     * set the view to display dishes ordered
     * @param dishNames dishes ordered
     */
    @Override
    public void setDisplayedDishNames(String[] dishNames) {
        placeOrderViewInterface.setDisplayedDishNames(dishNames);
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
        DecimalFormat df = new DecimalFormat("0.00");
        ArrayList<String> dishesString = new ArrayList<>();
        double totalPrice = 0;

        for (String dishName : dishesOrdered.keySet()) {
            totalPrice = getPriceAndAddStringToArrayList(dishesString, totalPrice, dishName);
        }
        totalPrice = totalPrice / 100;
        String totalPriceText = "\n\nTOTAL PRICE: " + df.format(totalPrice);
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

            dishesString.add(dishName + " x " + quantity + "   $" +
                    price + "\t each");

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



    // TODO: Delete hardcoded dishes later
    //Hardcoded dishList for testing

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

