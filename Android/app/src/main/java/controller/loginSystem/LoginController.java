package controller.loginSystem;

import constant.mangerSystem.UserType;
import constant.uiMessage.LoginResult;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import use_case.boundary.input.LoginInputBoundary;
import use_case.boundary.output.LoginOutputBoundary;
import use_case.userList.LoginUseCase;
import use_case.userList.UserList;

/**
 * Controls the process for logging in.
 */
public class LoginController {

    /**
     * The input use_case.boundary for the login use case.
     */
    private LoginInputBoundary loginInputBoundary;
    private UserList users;


    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     */
    public LoginController() {
        users = new UserList("src/main/resources/users.ser");
        //TODO hardcode since File I/O issue, need delete later
        generateUsers();
    }
    //TODO hardcode since File I/O issue, need delete later
    private void generateUsers() {
        users.addUser(new Manager());
        users.addUser(new Customer("1", "James", "12345"));
        users.addUser(new DeliveryStaff("2", "Amy", "12345", 3500));
        users.addUser(new ServingStaff("3", "Eve", "12345", 3665));
        users.addUser(new KitchenStaff("4", "Bob", "12345", 5000));
        users.addUser(new InventoryStaff("5", "Frank", "12345", 3600));
    }

    /**
     * Initialize use case input boundary and passing in the presenter interface
     * @param loginOutputBoundary instance of output boundary presenter
     */
    public void createUseCaseInteractor(LoginOutputBoundary loginOutputBoundary){
        this.loginInputBoundary = new LoginUseCase(loginOutputBoundary);
    }

    /**
     * Run the login use case where user with id is attempting to log into their
     * account with a password attempt.
     * @param id the id
     * @param password the password attempt
     * @return the result of user login attempt
     */
    public LoginResult runLogin(String id, String password) {
        return loginInputBoundary.logIn(id, password);
    }


    /**
     * Return UserType based on the login user id
     * @param id the login user id
     * @return UserType of the user
     */
    public UserType getUserTypeById(String id){
        return UserList.getUserTypeById(id);
    }

}
