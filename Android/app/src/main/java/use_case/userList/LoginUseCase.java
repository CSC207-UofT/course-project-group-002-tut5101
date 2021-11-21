package use_case.userList;

import constant.uiMessage.LoginResult;
import entity.User;
import use_case.boundary.LoginInputBoundary;

import java.util.HashMap;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * A list of users organized by id.
     */
    private final UserList users = new UserList();


    public LoginUseCase(HashMap userMap) {
        users.loadHashMap(userMap);
    }

    /**
     * Run the login use case.
     *
     * @param id       the id
     * @param password the password attempt
     * @return whether the attempt matches the password associated with id
     */
    public LoginResult logIn(String id, String password) {
        User user = UserList.getUserByUserId(id);
        if (user == null) {
            return LoginResult.NO_SUCH_USER;
        }
        if (user.passwordMatches(password)) {
            return LoginResult.SUCCESS;
        } else {
            return LoginResult.FAILURE;
        }
    }
}