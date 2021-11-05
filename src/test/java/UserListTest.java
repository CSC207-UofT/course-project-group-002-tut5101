/**
 * Tests for UseCase.entity.UserList Class
 *
 * @author Chan Yu & Naihe Xiao
 */

import constant.UserType;
import entity.*;
import org.junit.Before;
import org.junit.Test;
import use_case.UserList;

import static org.junit.Assert.assertEquals;

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
    }

    @Test
    public void testUserTypeById() {
        assertEquals(UserList.getUserTypeById("3"), UserType.CUSTOMER);
    }

//    //TODO delete this test later
//    @Test
//    public void testSaveToFile(){
//        UserReadWriter urf = new UserReadWriter();
//        urf.saveToFile(FileLocation.USER_FILE_LOCATION, userList.getUsers());
//    }
//
//    //TODO delete this test later
//    @Test
//    public void testReadFromFile(){
//        UserReadWriter urf = new UserReadWriter();
//        UserList users = new UserList();
//        users.loadHashMap(urf.readFromFile(FileLocation.USER_FILE_LOCATION));
//        System.out.println(users);
//    }


}
