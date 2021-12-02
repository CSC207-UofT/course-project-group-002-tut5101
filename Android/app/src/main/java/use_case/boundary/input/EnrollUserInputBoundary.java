package use_case.boundary.input;

import use_case.boundary.output.EnrollUserOutputBoundary;

public interface EnrollUserInputBoundary {
    void enrollNewStaff(String id, String name, String password, String userType);

    void getNewUserId();

    void setOutputBoundary(EnrollUserOutputBoundary outputBoundary);

    void getStaffTypes();
}
