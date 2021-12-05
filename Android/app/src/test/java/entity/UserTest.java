package entity;

import entity.user.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test the User class
 */
public class UserTest {
    private User user2;

    /**
     * setup before tests
     */
    @Before
    public void setUp() {
        user2 = new User("123", "Bob", "555");
    }

    /**
     * Test getter and setter methods for Id
     */
    @Test(timeout = 50)
    public void testGetSetID() {
        user2.setId("200");
        assertEquals("200", user2.getId());
    }

    /**
     * Test getter and setter methods for name
     */
    @Test(timeout = 50)
    public void testGetSetName() {
        user2.setName("Mary");
        assertEquals("Mary", user2.getName());
    }

    /**
     * Test getter and setter methods for password
     */
    @Test(timeout = 50)
    public void testGetSetPassword() {
        user2.setPassword("111");
        assertEquals("111", user2.getPassword());
    }


}
