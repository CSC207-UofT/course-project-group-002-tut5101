package userlist;

import constant.uimessage.LoginResult;
import org.junit.Before;
import org.junit.Test;
import use_case.boundary.input.LoginInputBoundary;
import use_case.boundary.output.LoginOutputBoundary;
import use_case.userlist.LoginUseCase;

public class LoginUseCaseTest {
    private LoginOutputBoundary loginOutputBoundary;

    /**
     * Setting up the test.
     */
    @Before
    public void setUp(){
        LoginUseCase loginUseCase = new LoginUseCase(loginOutputBoundary);
    }

    @Test
    public void testLogIn(){

    }





}
