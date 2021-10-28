package boundary;

public interface ServingStaffControllerInterface {
    void getServeDish() throws Exception;
    int getTableNumber();
    String getDishName();
    void completeDish();
}
