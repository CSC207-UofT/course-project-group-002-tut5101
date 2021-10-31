package boundary;

public interface ServingStaffControllerInterface {
    void getNextServeDish() throws Exception;
    String displayDish() throws Exception;
    void completeDish() throws Exception;
}
