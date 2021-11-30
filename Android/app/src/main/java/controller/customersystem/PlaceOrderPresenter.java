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
 * This is the Order controller which takes input of list of dish names that is passed from the UI and passes it to the
 * PlaceOrder use case to create a new order.
 * by Evelyn Chou
 * 2021-11-03
 */

public class PlaceOrderPresenter implements PlaceOrderOutputBoundary{
    //Controller class that interacts with use_case.customerSystem.PlaceOrder to place an order from the customer
    private HashMap<String, Integer> dishesOrdered;
    private DishList dishList;

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

    }

    public void setPlaceOrderViewInterface(PlaceOrderViewInterface placeOrderViewInterface) {
        this.placeOrderViewInterface = placeOrderViewInterface;
    }

    public void checkIntentDishes(Intent intent) {
        if (intent.hasExtra(BuildOrderInfo.DISHES.name())) {
            dishesOrdered = (HashMap<String, Integer>) intent.getSerializableExtra(BuildOrderInfo.DISHES.name());
            placeOrderViewInterface.displayDishesOrdered(dishesOrdered);
        }
    }

    @Override
    public void setDishNamePickerMaxValue(int size) {
        placeOrderViewInterface.setDishNamePickerMaxValue(size);
    }

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
         * @param orderType true if the order is dine in, false otherwise
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

    public void numberOfDishesInMenu() {
        dishList.numberOfDishesForPresenter();
    }

    public void allDishNames() {
        dishList.getAllDishNamesAsListForPresenter();
    }

    public void passDishesOrdered(int dishNameIndex, int dishQuantity) {
        dishList.passDishesOrdered(dishNameIndex, dishQuantity);
    }





}

