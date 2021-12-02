package use_case.userlist;

import constant.mangersystem.UserType;
import entity.User;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import org.junit.Before;
import org.junit.Test;

//TODO: fix this test issue.

import static org.junit.Assert.assertEquals;

/**
 * Tests for UseCase.entity.UserList Class
 *
 * @author Chan Yu & Naihe Xiao
 */
public class UserListTest {

    final UserList userList = new UserList(20);

    /**
     * Setting up the test.
     */
    @Before
    public void setUp() {
        userList.addUser(new Manager());
        userList.addUser(new Customer("2", "James", "12345"));
        userList.addUser(new Customer("3", "Steve", "12345"));
        userList.addUser(new Customer("4", "David", "12345"));
        userList.addUser(new DeliveryStaff("5", "Amy", "12345"));
        userList.addUser(new ServingStaff("6", "Eve", "12345"));
        userList.addUser(new ServingStaff("7", "Alice", "12345"));
        userList.addUser(new KitchenStaff("8", "Bob", "12345"));
        userList.addUser(new InventoryStaff("9", "Frank", "12345"));
    }

    /**
     * Testing addUser.
     *
     */
    @Test
    public void testAddUser() {
        assert(!userList.toString().equals(" "));
    }

    /**
     * Testing get the user type by id.
     *
     */
    @Test
    public void testUserTypeById() {
        assertEquals(UserList.getUserTypeById("3"), UserType.CUSTOMER);
    }

    /**
     * Testing get the user by id.
     *
     */
    @Test
    public void testUserById() {
        User user = UserList.getUserByUserId("3");
        assertEquals(user.toString(), "(UseCase.Customer) Steve: {id='3'}");
    }

    /**
     * Testing length.
     *
     */
    @Test
    public void testLength() {
        assertEquals(userList.length(), 9);
    }

    /**
     * Testing get the user by id.
     *
     */
    @Test
    public void testAddStaff() {
        userList.addStaff("21", "May", "32345", "KITCHEN");
        userList.addStaff("20", "April", "22345", "DELIVERY_STAFF");
        assertEquals(userList.length(), 11);
    }

}