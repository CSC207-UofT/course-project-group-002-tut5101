package boundary;

public interface Delivery {
    void delivered(String id) throws Exception;

    void getToBeDeliver(String id) throws Exception;

    String display(String id) throws Exception;

}
