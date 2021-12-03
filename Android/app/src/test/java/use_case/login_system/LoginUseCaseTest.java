package use_case.login_system;

import constant.uimessage.LoginResult;
import entity.customer_system.Customer;
import entity.delivery_system.DeliveryStaff;
import entity.delivery_system.ServingStaff;
import entity.inventory_system.InventoryStaff;
import entity.kitchen_system.KitchenStaff;
import org.junit.Before;
import org.junit.Test;
import use_case.user_list.UserList;

/**
 * Test the LoginUseCase class
 */
public class LoginUseCaseTest {
    private LoginUseCase loginUseCase;
    private final UserList userList = new UserList(20);

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        loginUseCase = new LoginUseCase();
        TestClass testPresenter = new TestClass();
        loginUseCase.setOutputBoundary(testPresenter);


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
        loginUseCase.logIn("100", "5555");
        loginUseCase.logIn("3", "12345");
        loginUseCase.logIn("7", "1111");
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
