package entity;

import entity.user.UserAttributes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAttributesTest {
    private UserAttributes testAttributes;
    /**
     * Set up a new user for testing
     */
    @Before
    public void setUp() {
        testAttributes = new UserAttributes("1", "2", "3");
    }
    /**
     * Test the id of user
     */
    @Test
    public void getId() {
        assertEquals("1", testAttributes.getId());
    }
    /**
     * Test the name of user
     */
    @Test
    public void getName() {
        assertEquals("2", testAttributes.getName());
    }
    /**
     * Test the password matching of the user
     */
    @Test
    public void getPassword() {
        assertEquals("3", testAttributes.getPassword());
    }
}