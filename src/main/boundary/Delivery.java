package boundary;
/**
 * Delivery interface
 * An interface for staffController to communicate with serveOrder and deliverOrder
 * By Dedong Xie and Raymond Liu
 * Created: 2021-10-24, Dedong Xie, named ServingStaffControllerInterface
 * Refactored: 2021-10-31, Raymond Liu, rename to Delivery
 */

public interface Delivery {
    void delivered(String id) throws Exception;
    void getToBeDeliver(String id) throws Exception;
    String display(String id) throws Exception;
}
