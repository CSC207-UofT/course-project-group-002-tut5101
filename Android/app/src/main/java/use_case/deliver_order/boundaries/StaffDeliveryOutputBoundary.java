package use_case.deliver_order.boundaries;

/**
 * The output use_case.boundary for CurrentItem presenter.
 */
public interface StaffDeliveryOutputBoundary {
    /**
     * Set the current item's info to view to present to user
     *
     * @param destination Destination of the item(order or dish)
     * @param info        Content of the item(dish names)
     */
    void setCurrentItemInfo(String destination, String info);
}
