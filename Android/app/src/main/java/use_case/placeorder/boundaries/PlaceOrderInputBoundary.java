package use_case.placeorder.boundaries;

import constant.order_system.OrderType;

/**
 * The input use_case.boundary for ManageMenu use case.
 */

// Note: The interface that the PlaceOrder implements
// Note how it specifies what the input (arguments) and output (return type) are.
public interface PlaceOrderInputBoundary {
    /**
     * Places an order by creating copies of the dishes in the menu then adding them to a new order, then adding the
     * order to the OrderQueue
     * @param orderType true if the dish is dineIn, false otherwise
     * @param dishNames string list of the names of dishes ordered
     * @param location the table number or delivery information of the order
     * @throws Exception if insufficient inventory
     */
    void placeOrder(OrderType orderType, String[] dishNames, String location) throws Exception;

}
