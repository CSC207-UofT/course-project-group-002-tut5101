package use_case.deliver_order;

import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ServingBufferTest {
    private Dish testDish;

    /**
     * Set up for the test
     */
    @Before
    public void setUp(){
        testDish = new Dish("1", 10, new HashMap<>(), 10);
    }

    /**
     * Test to get next dish to serve
     */
    @Test
    public void getNextToServe() {
        ServingBuffer.addDish(testDish);
        try {
            assertEquals(testDish, ServingBuffer.getNextToServe());
        } catch (Exception fail) {
            assert false;
        }
    }

    /**
     * Test to add a dish to the buffer
     */
    @Test
    public void addDish() {
        ServingBuffer.addDish(testDish);
    }

    /**
     * Test to reset the buffer
     */
    @Test
    public void testReset() {ServingBuffer.reset();}
}