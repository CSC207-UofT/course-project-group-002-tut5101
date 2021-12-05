package use_case.enroll_staff;

import constant.file_system.FileName;
import constant.manger_system.UserType;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import use_case.user_list.UserList;

public class EnrolStaffUseCaseTest {
    private final UserList userList = new UserList(FileName.USER_FILE);
    private EnrollStaffUseCase useCase = new EnrollStaffUseCase(userList);

    /**
     * Setting up the test.
     */
    @Before
    public void setUp() {
        TestClass testPresenter = new TestClass();
        useCase.setOutputBoundary(testPresenter);

        userList.addUser(new Customer("0", "James", "12345"));
        userList.addUser(new Customer("1", "Steve", "12345"));
        userList.addUser(new Customer("2", "David", "12345"));
        userList.addUser(new DeliveryStaff("3", "Amy", "12345"));
        userList.addUser(new ServingStaff("4", "Eve", "12345"));
        userList.addUser(new ServingStaff("5", "Alice", "12345"));
        userList.addUser(new KitchenStaff("6", "Bob", "12345"));
        userList.addUser(new InventoryStaff("7", "Frank", "12345"));
    }

    /**
     * Test the getStaff types method
     */
    @Test
    public void testGetStaffTypes() {
        useCase.getStaffTypes();
    }

    /**
     * Test enrollNewStaff method
     */
    @Test
    public void testEnrollNewStaff() {
        useCase.enrollNewStaff("8", "Mary", "12345", UserType.DELIVERY_STAFF);
        assertTrue(userList.getUsers().containsKey("8"));
    }

    /**
     * Test the getNewUserId method
     */
    @Test
    public void testGetNewUserID() {
        useCase.getNewUserId();
    }

    /**
     * Fake presenter class that implements the output boundary
     */
    private static class TestClass implements EnrollStaffOutputBoundary {

        /**
         * Test if this method is called from DishInformation
         * @param id next available user id
         */
        @Override
        public void setNewUserId(String id) {
            assertEquals("8", id);
        }

        /**
         * Test if this method is called from DishInformation
         * @param staffTypes array of staff types
         */
        @Override
        public void setAvailStaffTypeOptions(String[] staffTypes) {
            assert(true);
        }
    }
}
