package use_case.userList;

import constant.uiMessage.LoginResult;
import entity.User;
import use_case.boundary.LoginInputBoundary;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * A list of users organized by id.
     */
    private final UserList users;


    public LoginUseCase() {
        users = new UserList();
    }
    public LoginUseCase(String filepath){
        users = new UserList(filepath);
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

    public String Register(String[] para){

        String message =  this.users.addNewUser(para[0],para[1],para[2]);
        this.users.SavetoFile();
        return message;
    }
}