package presenter.manager_system;


import constant.manger_system.UserType;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import use_case.enroll_staff.EnrollStaffInputBoundary;
import use_case.enroll_staff.EnrollStaffOutputBoundary;
import use_case.enroll_staff.EnrollStaffUseCase;
import use_case.user_list.UserList;

/**
 * Controller class for manager.
 */
public class ManagerPresenter implements EnrollStaffOutputBoundary {

    /**
     * The input and output user_case.boundary for enrolling new staff use case.
     */
    private final EnrollStaffInputBoundary enrollUserInputBoundary;
    private EnrollStaffViewInterface enrollStaffViewInterface;


    /**
     * Method to generate a userList.
     *
     * @return a UserList.
     */
    private UserList loadUserList() {
        UserList userList = new UserList(20);
        userList = new UserList(6);
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
        userList.addUser(new ServingStaff("3", "Eve", "12345"));
        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
        userList.addUser(new InventoryStaff("5", "Frank", "12345"));
        return userList;
    }

    /**
     * Constructor of the ManagerController
     */
    public ManagerPresenter() {
        this.enrollUserInputBoundary = new EnrollStaffUseCase(loadUserList());
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
