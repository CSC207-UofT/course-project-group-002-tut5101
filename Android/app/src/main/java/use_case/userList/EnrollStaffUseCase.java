package use_case.userList;

import constant.mangerSystem.UserType;
import use_case.boundary.input.EnrollUserInputBoundary;
import use_case.boundary.output.EnrollUserOutputBoundary;

/**
 * Class for enrolling new staffs.
 */

public class EnrollStaffUseCase implements EnrollUserInputBoundary {

    private EnrollUserOutputBoundary enrollUserOutputBoundary;
    private final UserList userList;

    /**
     * Constructor for this class.
     * @param userList a list of users.
     */
    public EnrollStaffUseCase(UserList userList) {
        this.userList = userList;

    }

    /**
     * Set the output boundary for enrolling user.
     * @param enrollUserOutputBoundary the output boundary for enrolling user.
     */
    public void setOutputBoundary(EnrollUserOutputBoundary enrollUserOutputBoundary) {
        this.enrollUserOutputBoundary = enrollUserOutputBoundary;
    }

    /**
     * Set available user type options for presenter through output boundary
     */
    @Override
    public void getStaffTypes() {
        String[] staffTypes = {UserType.SERVING_STAFF.toString(),
                UserType.DELIVERY_STAFF.toString(),
                UserType.KITCHEN.toString(),
                UserType.INVENTORY_STAFF.toString()};
        this.enrollUserOutputBoundary.setAvailUserTypeOptions(staffTypes, staffTypes.length - 1);
    }

    /**
     * Add new staff user to user list
     * @param id        id of the new staff
     * @param name      name of the new staff
     * @param password  password of the new staff
     * @param userType  user type of the new staff
     * @param salary    salary of the new staff
     */
    @Override
    public void enrollNewStaff(String id, String name, String password, String userType, int salary) {
        userList.addStaff(id, name, password, userType, salary);
    }

    /**
     * Set new user id to next available number in presenter through output boundary
     */
    @Override
    public void getNewUserId() {
        int userListSize = this.userList.getUsers().size();
        this.enrollUserOutputBoundary.setNewUserId(String.valueOf(userListSize));
    }


}
