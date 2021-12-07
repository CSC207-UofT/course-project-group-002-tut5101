package presenter.user_system;


import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import org.junit.Before;
import org.junit.Test;
import presenter.user_system.view_interfaces.EnrollStaffViewInterface;
import use_case.user_list.UserList;

import static org.junit.Assert.assertEquals;


/**
 * Test the manager presenter.
 */
public class EnrollStaffPresenterTest {
    private EnrollStaffPresenter enrollStaffPresenter;
    private UserList userList;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        enrollStaffPresenter = new EnrollStaffPresenter();
        TestClass testPresenter = new TestClass();
        enrollStaffPresenter.setViewInterface(testPresenter);
        generateUserList();
    }

    /**
     * Generate list of users for testing
     */
    private void generateUserList() {
        userList = new UserList();
        userList.reset();
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
        userList.addUser(new ServingStaff("3", "Eve", "12345"));
        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
        userList.addUser(new InventoryStaff("5", "Frank", "12345"));
    }

    /**
     * Test getNewUserId method
     */
    @Test
    public void testGetNewUserId() {
        enrollStaffPresenter.getNewUserId();
    }

    /**
     * Test enrollNewUser method
     */
    @Test
    public void testEnrollNewUser(){
        enrollStaffPresenter.enrollNewUser("6", "Test", "12345", "KITCHEN");
        assertEquals(7, userList.length());
    }

    /**
     * Test getStaffTypes method
     */
    @Test
    public void testGetStaffTypes() {
        enrollStaffPresenter.getStaffTypes();
    }


    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements EnrollStaffViewInterface {

        /**
         * @param staffTypes array of available staff types
         */
        @Override
        public void setAvailStaffTypeOptions(String[] staffTypes) {
            assertEquals(staffTypes.length, 4);
        }

        /**
         * @param id id of the new staff
         */
        @Override
        public void setNewUserId(String id) {
            assertEquals(id, "6");
        }
    }

}
