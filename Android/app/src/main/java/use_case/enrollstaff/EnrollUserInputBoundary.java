package use_case.enrollstaff;

public interface EnrollUserInputBoundary {
    void enrollNewStaff(String id, String name, String password, String userType);

    void getNewUserId();

    void setOutputBoundary(EnrollUserOutputBoundary outputBoundary);

    void getStaffTypes();
}
