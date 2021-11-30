package controller.customersystem;

import android.content.Intent;
import constant.ordersystem.BuildOrderInfo;
import constant.ordersystem.OrderType;
import entity.orderlist.Dish;
import use_case.boundary.input.PlaceOrderInputBoundary;
import use_case.customersystem.PlaceOrder;
import use_case.customersystem.PlaceOrderOutputBoundary;
import use_case.dishlist.DishList;

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
    private final DishList dishList;


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
        placeOrderInputBoundary.setPlaceOrderOutputBoundary(this);

        this.dishList = new DishList();
        dishList.setPlaceOrderOutputBoundary(this);

        //TODO: Delete later
        generateDishList();

    }

    /**
     * set the PlaceOrderViewInterface attribute
     * @param placeOrderViewInterface the PlaceOrderViewInterface
     */
    public void setPlaceOrderViewInterface(PlaceOrderViewInterface placeOrderViewInterface) {
        this.placeOrderViewInterface = placeOrderViewInterface;
    }

    /**
     * get the current ordered dishes
     * @param dishesOrdered dishes ordered
     */
    public void setDishesOrdered(HashMap<String, Integer> dishesOrdered) {
       this.dishesOrdered = dishesOrdered;
    }

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
     * set the view to display dishes ordered
     * @param dishNames dishes ordered
     */
    @Override
    public void setDisplayedDishNames(String[] dishNames) {
        placeOrderViewInterface.setDisplayedDishNames(dishNames);
    }

    /**
     * method called from the use case through interface to update the list of dishes ordered
     *
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
        dishesOrdered.remove(dishName);
        dishesOrdered.put(dishName, dishQuantity);
        placeOrderViewInterface.displayDishesOrdered(dishesOrdered);
    }

        /**
         * runs the placeOrder method defined in the PlaceOrderInputBoundary
         * @param orderType the type of order
         * @param dishNames list of dish names ordered
         * @param location the table number if dine in, otherwise the address for the order to be delivered
         * @throws Exception if the place order fails
         */
        public void collectRunPlaceOrderInformation(OrderType orderType, String[]dishNames, String location) throws Exception {
            // Note: hands off the work to the use case class.

            placeOrderInputBoundary.placeOrder(orderType, dishNames, location);
        }

        public void collectRunPlaceOrderInformation(Intent intent) {
            String [] dishes = collectDishes();

            OrderType orderType = intent.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
            String location = intent.getStringExtra(BuildOrderInfo.LOCATION.name());

            try {
                collectRunPlaceOrderInformation(orderType, dishes, location);
                placeOrderViewInterface.orderSuccessfullyPlaced();
            }
            catch (Exception e) {
                String message = "Error, please try again";
                placeOrderViewInterface.setErrorMessage(message);
            }
        }

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

    /**
     * Get number of dishes in menu from dishList use case
     */
    public void numberOfDishesInMenu() {
        dishList.numberOfDishesForPresenter();
    }

    /**
     * Get names of all dishes from dishList use case
     */
    public void allDishNames() {
        dishList.getAllDishNamesAsListForPresenter();
    }

    /**
     * pass the index of the dish ordered and the quantity ordered to the dishList
     * @param dishNameIndex index referring to dish ordered
     * @param dishQuantity quantity ordered
     */
    public void passDishesOrdered(int dishNameIndex, int dishQuantity) {
        dishList.passDishesOrdered(dishNameIndex, dishQuantity);
    }

    /**
     * update the ordered dishes in the view
     */
    public void updateDishesOrdered() {
        placeOrderViewInterface.setDishesOrdered(dishesOrdered);
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
        dishList.addDish(d1);
        dishList.addDish(d2);
        dishList.addDish(d3);
        dishList.addDish(d4);
        dishList.addDish(d5);
        dishList.addDish(d6);
        dishList.addDish(d7);
    }



}

