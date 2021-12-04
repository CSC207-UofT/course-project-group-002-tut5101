package use_case.placeorder;

import constant.order_system.OrderType;

/**
 * The input use_case.boundary for ManageMenu use case.
 */

// Note: The interface that the PlaceOrder implements
// Note how it specifies what the input (arguments) and output (return type) are.
public interface PlaceOrderInputBoundary {
    void placeOrder(OrderType orderType, String[] dishNames, String location) throws Exception;

}
