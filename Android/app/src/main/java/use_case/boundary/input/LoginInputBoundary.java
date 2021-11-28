package use_case.boundary.input;

import constant.uiMessage.LoginResult;

/**
 * The input use_case.boundary for the login use case.
 */

public interface LoginInputBoundary {
    void logIn(String username, String password);
}
