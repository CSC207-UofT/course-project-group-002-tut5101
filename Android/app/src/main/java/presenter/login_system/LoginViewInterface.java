package presenter.login_system;

import constant.manager_system.UserType;
import constant.login_system.LoginResult;

/**
 * Login view interface between view and presenter
 */
public interface LoginViewInterface {
    /**
     * Present login result
     *
     * @param result login result
     */
    void presentLoginResult(LoginResult result);

    /**
     * Set user type used in view
     *
     * @param userType user type
     */
    void setUserType(UserType userType);
}
