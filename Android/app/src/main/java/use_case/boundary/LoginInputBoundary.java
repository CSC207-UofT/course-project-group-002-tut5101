package use_case.boundary;

import constant.uiMessage.LoginResult;

/**
 * The input use_case.boundary for the login use case.
 */

public interface LoginInputBoundary {
    LoginResult logIn(String username, String password);
}
