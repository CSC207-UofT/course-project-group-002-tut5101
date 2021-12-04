package use_case.deliver_order;

public interface ServeDishInterface {
    void delivered(String id) throws Exception;
    void getToBeDeliver(String id) throws Exception;
    String getItemInfo(String id);
}
