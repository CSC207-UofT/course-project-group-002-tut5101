package presenter.user_system;


import constant.manager_system.UserType;
import presenter.user_system.view_interfaces.EnrollStaffViewInterface;
import use_case.enroll_staff.boundaries.EnrollStaffInputBoundary;
import use_case.enroll_staff.boundaries.EnrollStaffOutputBoundary;
import use_case.enroll_staff.EnrollNewStaff;
import use_case.user_list.UserList;

/**
 * Controller class for manager.
 */
public class EnrollStaffPresenter implements EnrollStaffOutputBoundary {

    /**
     * The input and output user_case.boundary for enrolling new staff use case.
     */
    private final EnrollStaffInputBoundary enrollUserInputBoundary;
    private EnrollStaffViewInterface enrollStaffViewInterface;


    /**
     * Constructor of the ManagerController
     */
    public EnrollStaffPresenter() {
        this.enrollUserInputBoundary = new EnrollNewStaff(new UserList());
        this.enrollUserInputBoundary.setOutputBoundary(this);
    }

    /**
     * Set view interface for presenter.
     * @param viewInterface     view interface
     */
    public void setViewInterface(EnrollStaffViewInterface viewInterface) {
        this.enrollStaffViewInterface = viewInterface;
    }

    /**
     * Main method for enrolling new user.
     *
     * @param newUserId       id of new user
     * @param newUserName     name of new user
     * @param newUserPassword password of new user
     * @param userType        type of new user
     */
    public void enrollNewUser(String newUserId, String newUserName, String newUserPassword, String userType) {
        UserType currentUserType = null;
        for (UserType type : UserType.values()) {
            if (type.toString().equals(userType)){
                currentUserType = type;
                break;
            }
        }
        enrollUserInputBoundary.enrollNewStaff(newUserId, newUserName, newUserPassword, currentUserType);
    }

    /**
     * Get the id of the new user.
     */
    public void getNewUserId() {
        enrollUserInputBoundary.getNewUserId();
    }


    /**
     * Get the types of staffs.
     */
    public void getStaffTypes() {
        enrollUserInputBoundary.getStaffTypes();
    }

    /**
     * Output Boundary method implementation
     *
     * @param id of the user
     */
    @Override
    public void setNewUserId(String id) {
        this.enrollStaffViewInterface.setNewUserId(id);
    }

    /**
     * Output Boundary method implementation
     *
     * @param staffTypes String list of staff types
     */
    @Override
    public void setAvailStaffTypeOptions(String[] staffTypes) {
        this.enrollStaffViewInterface.setAvailStaffTypeOptions(staffTypes);
    }
}
