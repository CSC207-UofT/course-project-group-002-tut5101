package presenter.loginsystem;

import constant.mangersystem.UserType;
import constant.uimessage.LoginResult;

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
