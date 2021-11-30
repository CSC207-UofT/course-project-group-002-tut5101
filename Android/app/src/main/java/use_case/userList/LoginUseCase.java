package use_case.userList;

import constant.uiMessage.LoginResult;
import entity.User;
import use_case.boundary.input.LoginInputBoundary;
import use_case.boundary.output.LoginOutputBoundary;

import java.util.Objects;

public class LoginUseCase implements LoginInputBoundary {

//    private final UserList users;
    private final LoginOutputBoundary outputBoundary;


    public LoginUseCase(LoginOutputBoundary loginOutputBoundary){
//        this.users = new UserList(FileLocation.USER_FILE_LOCATION);
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