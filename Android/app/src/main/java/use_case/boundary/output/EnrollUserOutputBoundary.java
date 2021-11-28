package use_case.boundary.output;

public interface EnrollUserOutputBoundary {
    void setNewUserId(String id);

    void setNumPickerUserType(String[] staffTypes, int maxValue);
}
