package controller;

import boundary.LoginInputBoundary;
import constant.LoginResult;
import constant.UserType;
import ui.UserInterface;
import use_case.LoginUseCase;
import use_case.UserList;

/**
 * Controls the process for logging in.
 */
// If we handled logging out as well, this would be a good controller
// to do it in. It could have runLogin and runLogout methods. //TODO logout
public class LoginController {

    /**
     * The input boundary for the login use case.
     */
    private final LoginInputBoundary loginInputBoundary;


    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     */
    public LoginController() {
        this.loginInputBoundary = new LoginUseCase();
    }

    /**
     * Run the login use case where user with id is attempting to log into their
     * account with a password attempt.
     * @param id the id
     * @param password the password attempt
     * @return the result of user login attempt
     */
    public LoginResult runLogin(String id, String password) {
        // Note: hands off the work to the use case class.
        LoginResult result = loginInputBoundary.logIn(id, password);
        switch (result) {
            case SUCCESS:
                return LoginResult.SUCCESS;
            case FAILURE:
                return LoginResult.FAILURE;
            case NO_SUCH_USER:
                return LoginResult.NO_SUCH_USER;
        }
        return result;
    }

}
