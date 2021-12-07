package entity.delivery;

import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Test ServingStaff class
 */
public class ServingStaffTest {
    private ServingStaff servingStaff;

    private Dish coke;

    /**
     * Run before tests
     */
    @Before
    public void setUp() {
        servingStaff = new ServingStaff("staffNumber", "staffName", "password");

        coke = new Dish("Coke", 10.0, new HashMap<>(), 180);
        coke.setTableNum(1);
    }

    /**
     * Test setting ServingStaff current dish and checking if ServingStaff has a dish to serve
     */
    @Test(timeout = 50)
    public void testSetHasCurrentDish() {
        boolean before = servingStaff.hasCurrentDish();
        servingStaff.setCurrentDish(coke);
        boolean after = servingStaff.hasCurrentDish();
        assertFalse(before);
        assertTrue(after);
    }

    /**
     * Test completeServingDish method when there is no dish to be served and when there is a dish to be served
     */
    @Test(timeout = 50)
    public void testCompleteServingDish() {
        setUp();
        setUp();
        try {
            servingStaff.completeServingDish();
        }
        catch (Exception e) {
            assertFalse(false);
        }

        servingStaff.setCurrentDish(coke);
        boolean before = servingStaff.hasCurrentDish();

        try {
            servingStaff.completeServingDish();
        }
        catch (Exception e) {
            fail();
        }

        boolean after = servingStaff.hasCurrentDish();

        assertTrue(before);
        assertFalse(after);

    }

    /**
     * Test the displayDish method
     */
    @Test(timeout = 50)
    public void testDisplayDish() {
        setUp();
        String expectedNone = "";
        String actualNone = servingStaff.displayDish();

        servingStaff.setCurrentDish(coke);
        String expected = "Table: " + "1"
                + " Dish: " + "Coke"
                + "\n====================";
        String actual = servingStaff.displayDish();
        assertEquals(expectedNone, actualNone);
        assertEquals(expected, actual);
    }
}
