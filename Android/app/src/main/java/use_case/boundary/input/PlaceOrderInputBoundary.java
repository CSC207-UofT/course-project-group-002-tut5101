package use_case.boundary.input;

/**
 * The input use_case.boundary for ManageMenu use case.
 */

// Note: The interface that the PlaceOrder implements
// Note how it specifies what the input (arguments) and output (return type) are.
public interface PlaceOrderInputBoundary {
    void placeOrder(boolean dineIn, String[] dishNames, String location) throws Exception;

}
