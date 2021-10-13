/**
 * Tests for UserList Class
 *
 * @author Chan Yu & Naihe Xiao
 */
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class UserListTest {
    UserList userList = new UserList();


    @Before
    public void setUp() {
        this.userList.getUsers().put("1", new Manager("1", "Chan", "12345"));
        this.userList.getUsers().put("2", new Customer("2", "Howard", "12345"));
        this.userList.getUsers().put("3", new Manager("3", "Nathan", "12345"));
        this.userList.getUsers().put("4", new Customer("4", "George", "12345"));
        this.userList.getUsers().put("5", new Manager("5", "DeDong", "12345"));
        this.userList.getUsers().put("6", new Customer("6", "Eve", "12345"));
        this.userList.getUsers().put("7", new Manager("7", "Raymond", "12345"));
    }

    @Test(timeout = 50)
    public void testUserByIdentity() {
        assertTrue(this.userList.getUsers().containsKey("1"));
        assertFalse(this.userList.getUsers().containsKey("9"));
        assertEquals(this.userList.getUsers().size(), 7);
    }
}
