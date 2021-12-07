package use_case.deliver_order.boundaries;

/**
 * The input use_case.boundary for DeliverOrder use case.
 */

public interface DeliveryInputBoundary {
    /**
     * Mark the current order as delivered
     *
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a delivery staff.
     */
    void delivered(String id) throws Exception;

    /**
     * Get the next order to be delivered
     *
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a delivery staff.
     */
    void getToBeDeliver(String id) throws Exception;

    /**
     * Get description of the current order
     *
     * @param id The id of the user
     */
    void getItemInfo(String id);

    /**
     * Set output adapter for delivery Staff
     *
     * @param outputBoundary The output adapter that processes the outputs.
     */
    void setOutputBoundary(StaffDeliveryOutputBoundary outputBoundary);
}
