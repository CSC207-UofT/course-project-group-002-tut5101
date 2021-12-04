package use_case.enroll_staff;

import constant.manger_system.UserType;
import use_case.user_list.UserList;

/**
 * Class for enrolling new staffs.
 */

public class EnrollStaffUseCase implements EnrollStaffInputBoundary {

    private EnrollStaffOutputBoundary enrollStaffOutputBoundary;
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
    public void setOutputBoundary(EnrollStaffOutputBoundary enrollUserOutputBoundary) {
        this.enrollStaffOutputBoundary = enrollUserOutputBoundary;
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
        this.enrollStaffOutputBoundary.setAvailStaffTypeOptions(staffTypes);
    }

    /**
     * Add new staff user to user list
     * @param id        id of the new staff
     * @param name      name of the new staff
     * @param password  password of the new staff
     * @param userType  user type of the new staff
     */
    @Override
    public void enrollNewStaff(String id, String name, String password, UserType userType) {
        userList.addStaff(id, name, password, userType);
    }

    /**
     * Set new user id to next available number in presenter through output boundary
     */
    @Override
    public void getNewUserId() {
        int userListSize = this.userList.getUsers().size();
        this.enrollStaffOutputBoundary.setNewUserId(String.valueOf(userListSize));
    }


}
