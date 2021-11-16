package controller.loginSystem;

import constant.fileSystem.FileLocation;
import constant.uiMessage.LoginResult;
import constant.mangerSystem.UserType;
import gateway.UserReadWriter;
import use_case.userList.LoginUseCase;
import use_case.userList.UserList;
import use_case.boundary.LoginInputBoundary;

/**
 * Controls the process for logging in.
 */
public class LoginController {

    /**
     * The input use_case.boundary for the login use case.
     */
    private final LoginInputBoundary loginInputBoundary;


    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     */
    public LoginController() {
        UserReadWriter readWriter = new UserReadWriter();
        this.loginInputBoundary = new LoginUseCase(readWriter.readFromFile(FileLocation.USER_FILE_LOCATION));
    }

    /**
     * Run the login use case where user with id is attempting to log into their
     * account with a password attempt.
     * @param id the id
     * @param password the password attempt
     * @return the result of user login attempt
     */
    public LoginResult runLogin(String id, String password) {
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

    /**
     * Return UserType based on the login user id
     * @param id the login user id
     * @return UserType of the user
     */
    public UserType getUserTypeById(String id){
        return UserList.getUserTypeById(id);
    }
}
