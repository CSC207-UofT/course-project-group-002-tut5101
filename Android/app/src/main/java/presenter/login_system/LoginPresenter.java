package presenter.login_system;

import constant.ui_message.LoginResult;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUseCase;
import use_case.user_list.UserList;

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
        this.userList = new UserList();
        this.loginUseCase = new LoginUseCase();
        this.loginUseCase.setOutputBoundary(this);
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
     */
    public void getUserTypeById(String id) {
        this.loginViewInterface.setUserType(UserList.getUserTypeById(id));
    }

    /**
     * Implement output boundary method to present login result
     *
     * @param result of login
     */
    @Override
    public void presentLoginResult(LoginResult result) {
        this.loginViewInterface.presentLoginResult(result);
    }


}
