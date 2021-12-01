package entity.manager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Manager class
 */
public class ManagerTest {
    private Manager manager;
    private Manager manager2;

    /**
     * Setup before the test
     */
    @Before
    public void setUp() {
        manager = new Manager();
        manager2 = new Manager("1", "Chan", "12346");
    }

    /**
     * Test the manager constructor without parameters
     */
    @Test(timeout = 50)
    public void testManagerConstructorWOParam() {
        assertEquals("000", manager.getId());
        assertEquals("Boss", manager.getName());
        assertEquals("999", manager.getPassword());
    }

    /**
     * Test the manager constructor with parameters
     */
    @Test(timeout = 50)
    public void testManagerConstructorWParam() {
        assertEquals("1", manager2.getId());
        assertEquals("Chan", manager2.getName());
        assertEquals("12346", manager2.getPassword());
    }

    /**
     * Test the toString method
     */
    @Test(timeout = 50)
    public void testToString() {
        String expected = "(Manager) " + "Boss" + ": {" +
                "id='" + "000" + '\'' +
                '}';
        String actual = manager.toString();
        assertEquals(expected, actual);
    }
}
