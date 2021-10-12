import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserListTest {
    UserList userlist;


    @Before
    public void setUp(){
        userlist = new UserList();

    }

    @Test(timeout = 50)
    public void TestUserByIdentity(){
        assertTrue(userlist.getUsers().containsKey("1"));
        assertFalse(userlist.getUsers().containsKey("9"));
        assertEquals(userlist.getUsers().size(), 7);
    }
}
