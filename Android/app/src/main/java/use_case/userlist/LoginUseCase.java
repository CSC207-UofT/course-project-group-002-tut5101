package use_case.userlist;

import constant.uimessage.LoginResult;
import entity.User;
import use_case.boundary.input.LoginInputBoundary;
import use_case.boundary.output.LoginOutputBoundary;

import java.util.Objects;

/**
 * Use case class for user login.
 */
public class LoginUseCase implements LoginInputBoundary {

//    private final UserList users;
    private final LoginOutputBoundary outputBoundary;

    /**
     *
     * @param loginOutputBoundary output boundary for login in.
     */
    public LoginUseCase(LoginOutputBoundary loginOutputBoundary){
        this.outputBoundary = loginOutputBoundary;
    }
    /**
     * Run the login use case.
     *
     * @param id       the id
     * @param password the password attempt
     */
    public void logIn(String id, String password) {
        User user = UserList.getUserByUserId(id);
        if (user == null) {
            outputBoundary.presentLoginResult(LoginResult.NO_SUCH_USER);
        }
        if (Objects.requireNonNull(user).passwordMatches(password)) {
            outputBoundary.presentLoginResult(LoginResult.SUCCESS);
        } else {
            outputBoundary.presentLoginResult(LoginResult.FAILURE);
        }
    }

}