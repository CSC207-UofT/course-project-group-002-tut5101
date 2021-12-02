package use_case.login;

import constant.uimessage.LoginResult;
import entity.User;
import use_case.userlist.UserList;

import java.util.Objects;

/**
 * Use case class for user login.
 */
public class LoginUseCase {

    /**
     * use case output boundary attribute
     */
    private LoginOutputBoundary outputBoundary;

    /**
     * set output boundary for soft dependency
     *
     * @param loginOutputBoundary output boundary to presenter
     */
    public void setOutputBoundary(LoginOutputBoundary loginOutputBoundary) {
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