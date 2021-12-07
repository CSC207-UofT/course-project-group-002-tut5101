package presenter.delivery_system;

import constant.manager_system.UserType;
import constant.login_system.LoginResult;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import org.junit.Before;
import org.junit.Test;
import presenter.login_system.LoginPresenter;
import presenter.login_system.LoginViewInterface;
import use_case.user_list.UserList;

import static org.junit.Assert.assertEquals;
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
        generateUserList();
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
        login.presentLoginResult(LoginResult.FAILURE);
    }

    /**
     * Generate list of users for testing
     */
    private void generateUserList() {
        UserList userList = new UserList();
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
        userList.addUser(new ServingStaff("3", "Eve", "12345"));
        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
        userList.addUser(new InventoryStaff("5", "Frank", "12345"));
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
            assertEquals(result, LoginResult.FAILURE);
        }

        /**
         * testing use
         *
         * @param userType user type
         */
        @Override
        public void setUserType(UserType userType) {
            assertEquals(userType, UserType.DELIVERY_STAFF);
        }
    }
}
