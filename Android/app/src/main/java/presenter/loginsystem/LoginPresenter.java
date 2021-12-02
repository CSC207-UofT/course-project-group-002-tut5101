package presenter.loginsystem;

import constant.mangersystem.UserType;
import constant.uimessage.LoginResult;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUseCase;
import use_case.userlist.UserList;

/**
 * Controls the process for logging in.
 */
public class LoginPresenter implements LoginOutputBoundary {

    /**
     * The input use_case.boundary for the login use case.
     */
    private final LoginUseCase loginUseCase;
    private final UserList userList;
    private LoginViewInterface loginViewInterface;


    /**
     * A new LoginPresenter
     */
    public LoginPresenter() {
        this.userList = new UserList(6);
        this.loginUseCase = new LoginUseCase();
        this.loginUseCase.setOutputBoundary(this);


        //TODO hardcode since File I/O issue, need delete later
        generateUsers();
    }

    //TODO hardcode since File I/O issue, need delete later
    private void generateUsers() {
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
        userList.addUser(new ServingStaff("3", "Eve", "12345"));
        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
        userList.addUser(new InventoryStaff("5", "Frank", "12345"));
    }

    /**
     * initialize view interface
     *
     * @param viewInterface instance of view
     */
    public void setViewInterface(LoginViewInterface viewInterface) {
        this.loginViewInterface = viewInterface;
    }

    /**
     * Run the login use case where user with id is attempting to log into their
     * account with a password attempt.
     *
     * @param id       the id
     * @param password the password attempt
     */
    public void runLogin(String id, String password) {
        loginUseCase.logIn(id, password);
    }


    /**
     * Return UserType based on the login user id
     *
     * @param id the login user id
     * @return UserType of the user
     */
    public UserType getUserTypeById(String id) {
        return UserList.getUserTypeById(id);
    }

    /**
     * Implement output boundary method to present login result
     * @param result of login
     */
    @Override
    public void presentLoginResult(LoginResult result) {
        this.loginViewInterface.presentLoginResult(result);
    }


}
