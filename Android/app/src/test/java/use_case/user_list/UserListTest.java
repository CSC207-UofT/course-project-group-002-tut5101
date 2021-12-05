package use_case.user_list;

import constant.file_system.FileName;
import constant.manger_system.UserType;
import entity.user.User;
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
import static org.junit.Assert.assertNull;

/**
 * Tests for UseCase.entity.UserList Class
 *
 * @author Chan Yu & Naihe Xiao
 */
public class UserListTest {

    final UserList userList = new UserList();

    /**
     * Setting up the test.
     */
    @Before
    public void setUp() {
        userList.reset();
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
        assertEquals(UserType.MANAGER, UserList.getUserTypeById("000"));
        assertEquals(UserType.CUSTOMER, UserList.getUserTypeById("3"));
        assertEquals(UserType.DELIVERY_STAFF, UserList.getUserTypeById("5"));
        assertEquals(UserType.SERVING_STAFF, UserList.getUserTypeById("6"));
        assertEquals(UserType.INVENTORY_STAFF, UserList.getUserTypeById("9"));
        assertEquals(UserType.KITCHEN, UserList.getUserTypeById("8"));
        assertNull(UserList.getUserTypeById("1000"));
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
        assertEquals(9, userList.length());
    }

    /**
     * Testing get the user by id.
     *
     */
    @Test
    public void testAddStaff() {
        userList.addStaff("21", "May", "32345", UserType.KITCHEN);
        userList.addStaff("20", "April", "22345", UserType.SERVING_STAFF);
        userList.addStaff("22", "Mary", "12345", UserType.DELIVERY_STAFF);
        userList.addStaff("23", "Ron", "12345", UserType.INVENTORY_STAFF);
        assertEquals(13, userList.length());
    }

}
