package boundary;

import constant.LoginResult;

/**
 * The input boundary for the login use case.
 */
public interface LoginInputBoundary {
    LoginResult logIn(String username, String password);
}
