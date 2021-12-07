package presenter.user_system;

import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import org.junit.Before;
import org.junit.Test;
import presenter.user_system.view_interfaces.DisplayUsersViewInterface;
import use_case.user_list.UserList;

/**
 * Test the user presenter.
 */
public class UserPresenterTest {
    private UserPresenter userPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        userPresenter = new UserPresenter();
        TestClass testPresenter = new TestClass();
        userPresenter.setDisplayUsersViewInterface(testPresenter);
        generateUserList();

    }

    /**
     * Generate list of users for testing
     */
    private void generateUserList() {
        UserList userList = new UserList();
        userList.reset();
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
        userList.addUser(new ServingStaff("3", "Eve", "12345"));
        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
        userList.addUser(new InventoryStaff("5", "Frank", "12345"));
    }

    /**
     * Test displayUserAsString method
     */
    @Test
    public void testDisplayUsersAsString() {
        userPresenter.displayUsersAsString();
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements DisplayUsersViewInterface {

        @Override
        public void setUserItemsText(String userItems) {
            assert (!userItems.equals(""));
        }
    }
}