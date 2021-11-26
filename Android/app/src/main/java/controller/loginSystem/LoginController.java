package controller.loginSystem;

import constant.mangerSystem.UserType;
import constant.uiMessage.LoginResult;
import use_case.boundary.input.LoginInputBoundary;
import use_case.boundary.output.LoginOutputBoundary;
import use_case.userList.LoginUseCase;
import use_case.userList.UserList;

/**
 * Controls the process for logging in.
 */
public class LoginController {

    /**
     * The input use_case.boundary for the login use case.
     */
    private LoginInputBoundary loginInputBoundary;



    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     */
    public LoginController() {
    }

    /**
     * Initialize use case input boundary and passing in the presenter interface
     * @param loginOutputBoundary instance of output boundary presenter
     */
    public void createUseCaseInteractor(LoginOutputBoundary loginOutputBoundary){
        this.loginInputBoundary = new LoginUseCase(loginOutputBoundary);
    }

    /**
     * Run the login use case where user with id is attempting to log into their
     * account with a password attempt.
     * @param id the id
     * @param password the password attempt
     * @return the result of user login attempt
     */
    public LoginResult runLogin(String id, String password) {
        return loginInputBoundary.logIn(id, password);
    }


    /**
     * Return UserType based on the login user id
     * @param id the login user id
     * @return UserType of the user
     */
    public UserType getUserTypeById(String id){
        return UserList.getUserTypeById(id);
    }

    public String RegisterUser(String info){
        String[] para = info.split(",");
        return loginInputBoundary.Register(para);
    }
}
