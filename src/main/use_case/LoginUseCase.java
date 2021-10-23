package use_case;

import boundary.LoginInputBoundary;
import entity.User;

import java.io.IOException;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * A list of users organized by username.
     */
    private final UserList users;

    /**
     * Serializes and deserializes list of users
     */
    // UserReadWriter readWriter = new UserReadWriter();
    //TODO: inject this object and change the type to ReadWriter interface.

    /**
     * / The "output" of this use case.
     */
    // Note: This could also be a fully-fledged class if we need to return
    // information to the controller.
    public enum LoginResult {
        SUCCESS, FAILURE // Should we do NO_SUCH_USER as well as SUCCESS and FAILURE?
    }

    public LoginUseCase(UserList users) {
        this.users = users;
//        try {
//            readWriter.saveToFile("users.ser", users);
//        } catch (IOException e) {
//            System.out.println("User list did not save.");
//        }
    }

    /**
     * Run the login use case.
     * @param username the username
     * @param password the password attempt
     * @return whether the attempt matches the password associated with username
     */
    public LoginResult logIn(String username, String password) {
        User user = users.getUsers(username);
        if (user.passwordMatches(password)) {
            return LoginResult.SUCCESS;
        } else {
            return LoginResult.FAILURE;
        }
    }
}