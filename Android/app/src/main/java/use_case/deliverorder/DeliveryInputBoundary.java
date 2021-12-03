package use_case.deliverorder;

import use_case.deliverorder.StaffDeliveryOutputBoundary;

/**
 * The input use_case.boundary for DeliverOrder use case.
 */

public interface DeliveryInputBoundary {
    void delivered(String id) throws Exception;
    void getToBeDeliver(String id) throws Exception;
    void getItemInfo(String id) throws Exception;
    void setOutputBoundary(StaffDeliveryOutputBoundary outputBoundary);
}
