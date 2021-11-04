package use_case;

import boundary.LoginInputBoundary;
import constant.FileLocation;
import constant.LoginResult;
import entity.User;
import gateway.SerReadWriter;
import gateway.UserReadWriter;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * A list of users organized by id.
     */
    private final UserList users;


    public LoginUseCase() {
        SerReadWriter urf = new SerReadWriter();
        users = (UserList) urf.readFromFile(FileLocation.USER_FILE_LOCATION);
        System.out.println(users);

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