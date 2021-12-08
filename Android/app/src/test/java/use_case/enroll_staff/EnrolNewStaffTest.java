package use_case.enroll_staff;

import android.app.Activity;
import constant.file_system.FileName;
import constant.manager_system.UserType;
import entity.customer.Customer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.enroll_staff.boundaries.EnrollStaffOutputBoundary;
import use_case.user_list.UserList;


public class EnrolNewStaffTest {
    private final UserList userList = new UserList();
    private EnrollNewStaff useCase = new EnrollNewStaff();

    /**
     * Setting up the test.
     */
    @Before
    public void setUp() {
        TestClass testPresenter = new TestClass();
        useCase.setOutputBoundary(testPresenter);
        UserList.setContext(new Activity());
        UserList.setData("TEST"+ FileName.USER_FILE);

        userList.addUser(new Customer("0", "James", "12345"));
        userList.addUser(new Customer("1", "Steve", "12345"));
        useCase = new EnrollNewStaff(userList);
    }

    /**
     * Test the getStaff types method
     */
    @Test
    public void testGetStaffTypes() {
        useCase = new EnrollNewStaff();
        useCase.getStaffTypes();
    }

    /**
     * Test enrollNewStaff method
     */
    @Test
    public void testEnrollNewStaff() {
        useCase.enrollNewStaff("1", "12345", "12345", UserType.DELIVERY_STAFF);
    }

    /**
     * Test the getNewUserId method
     */
    @Test
    public void testGetNewUserID() {
        useCase = new EnrollNewStaff();
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
