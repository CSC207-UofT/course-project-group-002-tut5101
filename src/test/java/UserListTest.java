import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class UserListTest {
    UserList userlist;


    @Before
    public void setUp(){
        HashMap<String, User> userList = new HashMap<String, User>();
        userList.put("1", new Manager("1", "Chan", "12345"));
        userList.put("2", new Customer("2", "Howard", "12345"));
        userList.put("3", new Manager("3", "Nathan", "12345"));
        userList.put("4", new Customer("4", "George", "12345"));
        userList.put("5", new Manager("5", "DeDong", "12345"));
        userList.put("6", new Customer("6", "Eve", "12345"));
        userList.put("7", new Manager("7", "Raymond", "12345"));userlist = new UserList();

    }

    @Test(timeout = 50)
    public void testUserByIdentity(){
        assertTrue(userlist.getUsers().containsKey("1"));
        assertFalse(userlist.getUsers().containsKey("9"));
        assertEquals(userlist.getUsers().size(), 7);
    }
}
