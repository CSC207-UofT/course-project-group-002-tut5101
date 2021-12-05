package entity;

import entity.user.UserAttributes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAttributesTest {
    private UserAttributes testAttributes;

    @Before
    public void setUp() throws Exception {
        testAttributes = new UserAttributes("1", "2", "3");
    }

    @Test
    public void getId() {
        assertEquals("1", testAttributes.getId());
    }

    @Test
    public void getName() {
        assertEquals("2", testAttributes.getName());
    }

    @Test
    public void getPassword() {
        assertEquals("3", testAttributes.getPassword());
    }
}