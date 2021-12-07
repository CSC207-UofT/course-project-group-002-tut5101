package use_case.login;

import constant.login_system.LoginResult;

/**
 * Login output boundary between login use case and presenter
 */
public interface LoginOutputBoundary {
    /**
     * Present the login result to present
     *
     * @param result login result
     */
    void presentLoginResult(LoginResult result);
}
