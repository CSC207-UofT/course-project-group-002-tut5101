package use_case;

import entity.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ServingBufferTest {
    ServingBuffer buffer;
    Dish dish1;

    @Before
    public void setUp() throws Exception {
        buffer = new ServingBuffer();
        dish1 = new Dish("a", 10.0, new HashMap<>(), 10);
    }

    @Test
    public void addDish() {
        try {
            buffer.addDish(dish1);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void getNextToServe() {
        try {
            buffer.addDish(dish1);
            assertEquals(dish1.getName(), buffer.getNextToServe().getName());
        } catch (Exception e) {
            assert false;
        }
    }
}