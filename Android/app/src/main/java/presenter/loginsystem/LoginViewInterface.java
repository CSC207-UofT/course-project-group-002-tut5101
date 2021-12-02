package presenter.loginsystem;

import constant.uimessage.LoginResult;

/**
 * Login view interface between view and presenter
 */
public interface LoginViewInterface {
    /**
     *
     * @param result login result
     */
    void presentLoginResult(LoginResult result);
}
