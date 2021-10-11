/** Test file for PlacedOrderQueue class
 * By Dedong Xie
 * 2021-10-11
 */
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class PlacedOrderQueueTest {
    PlacedOrderQueue queue;
    List<Dish> dishList;
    String[] ingredients;
    Order orderOne;
    Order orderTwo;

    @BeforeEach
    public void setUp() {
        queue = new PlacedOrderQueue();
        ingredients = new String[]{"a", "b"};
        dishList = new ArrayList<Dish>();
        dishList.add(new Dish("a", 10, ingredients, 100));
        dishList.add(new Dish("b", 10, ingredients, 120));
        orderOne = new Order(1, dishList);
        orderTwo = new Order(1, dishList);
    }

    @Test
    @Timeout(50)
    @DisplayName("Test add single order to the queue")
    public void TestAddOrderSingleAdd() {
        assertTrue(queue.addOrder(orderOne));
    }

    @Test
    @Timeout(50)
    public void TestAddOrderMultipleAdd() {
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderTwo));
    }

    @Test
    @Timeout(50)
    public void TestGetNextOrderSingleNext() {
        Assert.assertEquals(null, queue.getNextOrder());
        assertTrue(queue.addOrder(orderOne));
        Assert.assertEquals(orderOne, queue.getNextOrder());
        assertTrue(queue.addOrder(orderTwo));
        Assert.assertEquals(orderTwo, queue.getNextOrder());
    }

    @Test
    @Timeout(50)
    public void TestGetNextOrderMultipleNext() {
        assertNull(queue.getNextOrder());
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderOne));
        Assert.assertEquals(orderOne, queue.getNextOrder());
        assertTrue(queue.addOrder(orderTwo));
        Assert.assertNotEquals(orderTwo, queue.getNextOrder());
        Assert.assertNotEquals(orderTwo, queue.getNextOrder());
        Assert.assertEquals(orderTwo, queue.getNextOrder());
    }
}