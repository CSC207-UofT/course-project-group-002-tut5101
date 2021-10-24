package controller;

import boundary.PlaceOrderInputBoundary;

public class OrderController {
    //Controller class that interacts with use_case.PlaceOrder to place an order from the customer

    /**
     * The input boundary for the place order.
     */
    private final PlaceOrderInputBoundary placeOrderInputBoundary;

    /**
     * A new OrderController for the use case defined by the PlaceOrderInputBoundary.
     * @param placeOrderInputBoundary the input boundary for the place order use case
     */
    public OrderController(PlaceOrderInputBoundary placeOrderInputBoundary) {
        this.placeOrderInputBoundary = placeOrderInputBoundary;
    }

    public void runPlaceOrder(boolean dineIn, String[] dishNames, String location) throws Exception {
        // Note: hands off the work to the use case class.

        placeOrderInputBoundary.placeOrder(dineIn, dishNames, location);
    }

}
