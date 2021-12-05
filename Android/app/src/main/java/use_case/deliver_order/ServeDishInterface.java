package use_case.deliver_order;

public interface ServeDishInterface {
    void delivered(String id) ;
    void getToBeDeliver(String id);
    String getItemInfo(String id);
}
