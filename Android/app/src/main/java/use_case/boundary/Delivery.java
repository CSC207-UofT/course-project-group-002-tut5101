package use_case.boundary;

/**
 * The input use_case.boundary for DeliverOrder use case.
 */

public interface Delivery {
    void delivered(String id) throws Exception;
    void getToBeDeliver(String id) throws Exception;
    String display(String id) throws Exception;
}
