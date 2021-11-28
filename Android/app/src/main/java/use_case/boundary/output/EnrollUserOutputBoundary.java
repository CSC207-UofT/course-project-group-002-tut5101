package use_case.boundary.output;

public interface EnrollUserOutputBoundary {
    void setNewUserId(String id);

    void setAvailUserTypeOptions(String[] staffTypes, int maxValue);
}
