package boundary;

public interface ServingOrderInterface {
    void completeCurrentDish() throws Exception;
    void getToServe() throws Exception;
    String displayDish() throws Exception;
}
