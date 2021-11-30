package controller.managersystem;


import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import use_case.boundary.input.EnrollUserInputBoundary;
import use_case.boundary.output.EnrollUserOutputBoundary;
import use_case.userlist.EnrollStaffUseCase;
import use_case.userlist.UserList;

/**
 * Controller class for manager.
 */


public class ManagerController {

    /**
     * The input and output user_case.boundary for enrolling new staff use case.
     */
    private final EnrollUserInputBoundary enrollUserInputBoundary;
    private UserList userList;


    /**
     * Method to generate a userList.
     *
     * @return a UserList.
     */
    private UserList loadUserList() {
        //TODO hardcode since File I/O issue, need delete later
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345", 3500));
        userList.addUser(new ServingStaff("3", "Eve", "12345", 3665));
        userList.addUser(new KitchenStaff("4", "Bob", "12345", 5000));
        userList.addUser(new InventoryStaff("5", "Frank", "12345", 3600));
        return userList;
    }

    /**
     * Constructor of the ManagerController
     */
    public ManagerController() {
        this.enrollUserInputBoundary = new EnrollStaffUseCase(loadUserList());
    }

    /**
     * Main method for enrolling new user.
     *
     * @param newUserId id of new user
     * @param newUserName name of new user
     * @param newUserPassword password of new user
     * @param userType type of new user
     * @param salary salary of new user
     */
    public void enrollNewUser(String newUserId, String newUserName, String newUserPassword,
                              String userType, String salary) {
        enrollUserInputBoundary.enrollNewStaff(newUserId, newUserName, newUserPassword,
                userType, Integer.parseInt(salary));
    }

    /**
     *
     * Get the id of the new user.
     */
    public void getNewUserId() {
        enrollUserInputBoundary.getNewUserId();
    }

    /**
     *
     * Set output boundary for enroll user.
     */
    public void setEnrollUserOutputBoundary(EnrollUserOutputBoundary outputBoundary) {
        enrollUserInputBoundary.setOutputBoundary(outputBoundary);
    }

    /**
     *
     * Get the types of staffs.
     */
    public void getStaffTypes() {
        enrollUserInputBoundary.getStaffTypes();
    }
}
