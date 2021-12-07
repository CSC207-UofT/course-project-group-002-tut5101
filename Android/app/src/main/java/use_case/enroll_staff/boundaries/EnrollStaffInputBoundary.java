package use_case.enroll_staff.boundaries;

import constant.manager_system.UserType;

/**
 * Input Boundary of Enroll Staff Use Case
 */
public interface EnrollStaffInputBoundary {

    /**
     * Enroll new staff
     *
     * @param id       id of the new staff
     * @param name     name of the new staff
     * @param password password of the new staff
     * @param userType user type of the new staff
     */
    void enrollNewStaff(String id, String name, String password, UserType userType);

    /**
     * Request next available user id
     */
    void getNewUserId();

    /**
     * Set output boundary for use case
     *
     * @param outputBoundary output boundary for use case
     */
    void setOutputBoundary(EnrollStaffOutputBoundary outputBoundary);

    /**
     * Request available staff types
     */
    void getStaffTypes();
}
