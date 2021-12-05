package entity.inventory;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the HasFreshness class
 */
public class HasFreshnessTest {
    private HasFreshness hasFreshness;

    /**
     * setup before tests
     */
    @Before
    public void setUp() {
        hasFreshness = new HasFreshness("Test", 40.0, 20, "Fresh", 20220731);
        hasFreshness.setFreshness("Fresh");
    }

    /**
     * Test the getName method
     */
    @Test(timeout = 50)
    public void testGetName() {
        String expected = "Test";
        String actual = hasFreshness.getName();
        assertEquals(expected, actual);
    }

    /**
     * Test whether inventory item is used up
     */
    @Test(timeout = 50)
    public void testGetUsedUp() {
        boolean actual = hasFreshness.getUsedUp();
        assertFalse(actual);
    }

    /**
     * Test the getQuantity method
     */
    @Test(timeout = 50)
    public void testGetQuantity() {
        int expected = 20;
        int actual = hasFreshness.getQuantity();
        assertEquals(expected, actual);
    }

    /**
     * Test the updateQuantity method
     */
    @Test(timeout = 50)
    public void testUpdateQuantity() {
        String expectedMessage = "Successfully updated";
        String actualMessage = hasFreshness.updateQuantity(10);
        assertEquals(expectedMessage, actualMessage);

        int expectedQuantity = 10;
        int actualQuantity = hasFreshness.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);

        String expectedMessage2 = "Not enough";
        String actualMessage2 = hasFreshness.updateQuantity(20);
        assertEquals(expectedMessage2, actualMessage2);

        hasFreshness.updateQuantity(10);
        boolean actualUsedUp = hasFreshness.getUsedUp();
        assertTrue(actualUsedUp);
    }

    /**
     * Test the toString method
     */
    @Test(timeout = 50)
    public void testToString() {
        String expected = "Test"+ ","+ 40.0 +
                ","+ 20 +","+ "Fresh" + ","+ 20220731;
        String actual = hasFreshness.toString();
        assertEquals(expected, actual);
    }

    /**
     * Test the equals method
     */
    @Test(timeout = 50)
    public void equals() {
        HasFreshness test = new HasFreshness("Test", 40.0, 20, "Fresh", 20220731);
        assert(hasFreshness.equals(test));
    }

}
