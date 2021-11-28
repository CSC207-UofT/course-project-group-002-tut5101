
import constant.fileSystem.FileLocation;
import constant.mangerSystem.UserType;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.customer.Customer;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import gateway.ReadWriter;
import gateway.SerReadWriter;
import org.junit.Before;
import org.junit.Test;
import use_case.userList.UserList;

import static org.junit.Assert.assertEquals;

/**
 * Tests for UseCase.entity.UserList Class
 *
 * @author Chan Yu & Naihe Xiao
 */
public class UserListTest {
    UserList userList = new UserList();

    @Before
    public void setUp() {
        UserList.addUser(new Manager());
        UserList.addUser(new Customer("2", "James", "12345"));
        UserList.addUser(new Customer("3", "Steve", "12345"));
        UserList.addUser(new Customer("4", "David", "12345"));
        UserList.addUser(new DeliveryStaff("5", "Amy", "12345", 3500));
        UserList.addUser(new ServingStaff("6", "Eve", "12345", 3665));
        UserList.addUser(new ServingStaff("7", "Alice", "12345", 3700));
        UserList.addUser(new KitchenStaff("8", "Bob", "12345", 5000));
        UserList.addUser(new InventoryStaff("9", "Frank", "12345", 3600));
    }

    @Test
    public void testUserTypeById() {
        assertEquals(UserList.getUserTypeById("3"), UserType.CUSTOMER);
    }

    @Test
    public void testSaveToFile(){
        ReadWriter rw = new SerReadWriter();
        rw.saveToFile(FileLocation.USER_FILE_LOCATION, userList.getUsers());
    }

    @Test
    public void testReadFromFile(){
        ReadWriter rw = new SerReadWriter();
        System.out.println(rw.readFromFile(FileLocation.USER_FILE_LOCATION));
    }
}
