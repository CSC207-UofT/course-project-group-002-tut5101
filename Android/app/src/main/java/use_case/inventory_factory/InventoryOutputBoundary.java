package use_case.inventory_factory;
/**
 * The output presenter.boundary for Update Quantity presenter.
 */
public interface InventoryOutputBoundary {
    /**
     * Pass the message through interface
     * @param message the message to send
     */
    String getMessage(String message);
}
