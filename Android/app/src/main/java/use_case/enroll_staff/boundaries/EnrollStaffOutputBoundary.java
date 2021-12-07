package use_case.enroll_staff.boundaries;

/**
 * Output Boundary for enroll staff use case to presenter
 */
public interface EnrollStaffOutputBoundary {
    /**
     * Set next available user id in presenter
     *
     * @param id next available user id
     */
    void setNewUserId(String id);

    /**
     * Set available staff types in presenter
     *
     * @param staffTypes array of staff types
     */
    void setAvailStaffTypeOptions(String[] staffTypes);
}
