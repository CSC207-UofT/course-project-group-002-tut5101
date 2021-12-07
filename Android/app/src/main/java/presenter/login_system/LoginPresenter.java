package presenter.login_system;

import constant.login_system.LoginResult;
import use_case.login.LoginOutputBoundary;
import use_case.login.UserLogin;
import use_case.user_list.UserList;

/**
 * Controls the process for logging in.
 */
public class LoginPresenter implements LoginOutputBoundary {

    /**
     * The input use_case.boundary for the login use case.
     */
    private final UserLogin userLogin;
    private LoginViewInterface loginViewInterface;


    /**
     * A new LoginPresenter
     */
    public LoginPresenter() {
        this.userLogin = new UserLogin();
        this.userLogin.setOutputBoundary(this);
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
        userLogin.logIn(id, password);
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
