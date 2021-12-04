package use_case.deliver_order;

/**
 * The input use_case.boundary for DeliverOrder use case.
 */

public interface DeliveryInputBoundary {
    void delivered(String id) throws Exception;
    void getToBeDeliver(String id) throws Exception;
    void getItemInfo(String id) throws Exception;
    void setOutputBoundary(StaffDeliveryOutputBoundary outputBoundary);
}
