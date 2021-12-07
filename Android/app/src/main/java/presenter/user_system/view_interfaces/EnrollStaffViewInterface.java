package presenter.user_system.view_interfaces;

/**
 * ViewInterface of enroll staff presenter
 */
public interface EnrollStaffViewInterface {

    /**
     * Set available staff types for view
     *
     * @param staffTypes array of available staff types
     */
    void setAvailStaffTypeOptions(String[] staffTypes);

    /**
     * Set next available user id for view
     *
     * @param id id of the new staff
     */
    void setNewUserId(String id);

}
