package use_case.login;

import constant.login_system.LoginResult;
import entity.user.User;
import use_case.user_list.UserList;

import java.util.Objects;

/**
 * Use case class for user login.
 */
public class UserLogin {

    /**
     * Use case output boundary attribute
     */
    private LoginOutputBoundary outputBoundary;

    /**
     * Set output boundary for soft dependency
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
        } else {
            if (Objects.requireNonNull(user).passwordMatches(password)) {
                outputBoundary.presentLoginResult(LoginResult.SUCCESS);
            } else {
                outputBoundary.presentLoginResult(LoginResult.FAILURE);
            }
        }
    }
}