package use_case.login;

import android.app.Activity;
import constant.file_system.FileName;
import constant.login_system.LoginResult;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import org.junit.Before;
import org.junit.Test;
import use_case.user_list.UserList;

/**
 * Test the LoginUseCase class
 */
public class UserLoginTest {
    private UserLogin userLogin;
    private final UserList userList = new UserList();

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        userLogin = new UserLogin();
        UserList.setContext(new Activity());
        UserList.setData("TEST"+ FileName.USER_FILE);
        TestClass testPresenter = new TestClass();
        userLogin.setOutputBoundary(testPresenter);


        userList.addUser(new Customer("0", "James", "12345"));
        userList.addUser(new DeliveryStaff("3", "Amy", "12345"));
        userList.addUser(new ServingStaff("5", "Alice", "12345"));
        userList.addUser(new KitchenStaff("6", "Bob", "12345"));
        userList.addUser(new InventoryStaff("7", "Frank", "12345"));


    }

    /**
     * Test the logIn method
     */
    @Test
    public void testLogIn() {
        userLogin.logIn("100", "5555");
        userLogin.logIn("3", "12345");
        userLogin.logIn("7", "1111");
    }


    /**
     * Fake presenter class that implements the output boundary
     */
    private static class TestClass implements LoginOutputBoundary {

        /**
         * Test if the LoginUseCase calls this method
         * @param result login result
         */
        @Override
        public void presentLoginResult(LoginResult result) {
            assert true;
        }
    }
}
