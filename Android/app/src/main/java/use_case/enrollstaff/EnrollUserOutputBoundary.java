package use_case.enrollstaff;

public interface EnrollUserOutputBoundary {
    void setNewUserId(String id);

    void setAvailUserTypeOptions(String[] staffTypes, int maxValue);
}
