package controller;

import boundary.PlaceOrderInputBoundary;
import use_case.PlaceOrder;

public class OrderController {
    //Controller class that interacts with use_case.PlaceOrder to place an order from the customer

    /**
     * The input boundary for the place order.
     */
    private final PlaceOrderInputBoundary placeOrderInputBoundary;

    /**
     * A new OrderController for the use case defined by the PlaceOrderInputBoundary.
     */
    public OrderController() {
        this.placeOrderInputBoundary = new PlaceOrder();
    }

    public void runPlaceOrder(boolean dineIn, String[] dishNames, String location) throws Exception {
        // Note: hands off the work to the use case class.

        placeOrderInputBoundary.placeOrder(dineIn, dishNames, location);
    }

}
