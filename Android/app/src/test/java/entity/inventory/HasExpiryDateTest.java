package entity.inventory;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the HasExpiryDate class
 */
public class HasExpiryDateTest {
    private HasExpiryDate hasExpiryDate;

    /**
     * setup before tests
     */
    @Before
    public void setUp() {
        hasExpiryDate = new HasExpiryDate("Test", 40.0, 20, 20220731);
    }

    /**
     * Test the setID method
     */
    @Test
    public void testSetID() {
        hasExpiryDate.setId(2);
    }
    /**
     * Test the getName method
     */
    @Test(timeout = 50)
    public void testGetName() {
        String expected = "Test";
        String actual = hasExpiryDate.getName();
        assertEquals(expected, actual);
    }

    /**
     * Test the getUsedUp method
     */
    @Test(timeout = 50)
    public void testGetUsedUp() {
        boolean actual = hasExpiryDate.getUsedUp();
        assertFalse(actual);
    }

    /**
     * Test the getQuantity method
     */
    @Test(timeout = 50)
    public void testGetQuantity() {
        int expected = 20;
        int actual = hasExpiryDate.getQuantity();
        assertEquals(expected, actual);
    }

    /**
     * Test the updateQuantity method
     */
    @Test(timeout = 50)
    public void testUpdateQuantity() {
        String expectedMessage = "Successfully updated";
        String actualMessage = hasExpiryDate.updateQuantity(10);
        assertEquals(expectedMessage, actualMessage);

        int expectedQuantity = 10;
        int actualQuantity = hasExpiryDate.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);

        String expectedMessage2 = "Not enough";
        String actualMessage2 = hasExpiryDate.updateQuantity(20);
        assertEquals(expectedMessage2, actualMessage2);

        hasExpiryDate.updateQuantity(10);
        boolean actualUsedUp = hasExpiryDate.getUsedUp();
        assertTrue(actualUsedUp);
    }


    /**
     * Test the toString method
     */
    @Test(timeout = 50)
    public void testToString() {
        String expected = "Test" + ","+ 40.0 +
                ","+ 20 +","+ 20220731;
        String actual = hasExpiryDate.toString();
        assertEquals(expected, actual);
    }

    /**
     * Test the equals method
     */
    @Test(timeout = 50)
    public void equals() {
        HasExpiryDate test = new HasExpiryDate("Test", 40.0, 20, 20220731);
        assert(hasExpiryDate.equals(test));
    }

}
