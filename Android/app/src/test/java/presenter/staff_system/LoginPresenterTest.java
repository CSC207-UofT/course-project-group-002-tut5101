package presenter.staff_system;

import constant.manger_system.UserType;
import constant.ui_message.LoginResult;
import org.junit.Before;
import org.junit.Test;
import presenter.login_system.LoginPresenter;
import presenter.login_system.LoginViewInterface;

/**
 * Testing the login presenter.
 */
public class LoginPresenterTest {

    private LoginPresenter login;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        login = new LoginPresenter();
        TestClass testPresenter = new TestClass();
        login.setViewInterface(testPresenter);
    }

    /**
     * Test the runLogin method
     */
    @Test
    public void runLogin(){
        login.runLogin("1","23");
    }

    /**
     * Test the getUserTypeById method
     */
    @Test
    public void getUserTypeById(){
        login.getUserTypeById("2");
    }

    /**
     * Test the getUserTypeById method
     */
    @Test
    public void presentLoginResult(){
        login.presentLoginResult(LoginResult.SUCCESS);
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements LoginViewInterface {

        /**
         * testing use
         *
         * @param result login result
         */
        @Override
        public void presentLoginResult(LoginResult result) {
            assert true;
        }

        /**
         * testing use
         *
         * @param userType user type
         */
        @Override
        public void setUserType(UserType userType) {
            assert true;
        }
    }

}
