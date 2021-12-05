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

import java.util.HashMap;

public class EnrolStaffUseCaseTest {
    private final UserList userList = new UserList();
    private EnrollStaffUseCase useCase = new EnrollStaffUseCase();

    /**
     * Setting up the test.
     */
    @Before
    public void setUp() {
        TestClass testPresenter = new TestClass();
        useCase.setOutputBoundary(testPresenter);
        UserList.users = new HashMap<>();

        userList.addUser(new Customer("0", "James", "12345"));
        userList.addUser(new Customer("1", "Steve", "12345"));
        useCase = new EnrollStaffUseCase(userList);
    }

    /**
     * Test the getStaff types method
     */
    @Test
    public void testGetStaffTypes() {
        assert true;
    }

    /**
     * Test enrollNewStaff method
     */
    @Test
    public void testEnrollNewStaff() {
        assert true;
    }

    /**
     * Test the getNewUserId method
     */
    @Test
    public void testGetNewUserID() {
        assert true;
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
