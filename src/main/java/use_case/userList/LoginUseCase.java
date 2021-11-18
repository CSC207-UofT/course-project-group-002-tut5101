package use_case.userList;

import constant.fileSystem.FileLocation;
import gateway.SerReadWriter;
import use_case.boundary.LoginInputBoundary;
import constant.uiMessage.LoginResult;
import entity.User;

import java.util.HashMap;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * A list of users organized by id.
     */
    private final UserList users = new UserList();
    SerReadWriter readWriter = new SerReadWriter();

    public LoginUseCase(HashMap userMap) {
        users.loadHashMap(userMap);
    }
    public LoginUseCase(String filepath){
        HashMap map = readWriter.readFromFile(filepath);
        users.loadHashMap(map);
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