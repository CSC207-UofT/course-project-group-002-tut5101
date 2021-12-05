package use_case.deliver_order;

import entity.order_list.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ServingBufferTest {
    private Dish testDish;

    @Before
    public void setUp() throws Exception {
        testDish = new Dish("1", 10, new HashMap<>(), 10);
    }

    @Test
    public void getNextToServe() throws Exception {
        ServingBuffer.addDish(testDish);
        assertEquals(testDish, ServingBuffer.getNextToServe());
    }

    @Test
    public void addDish() {
        ServingBuffer.addDish(testDish);
    }
}