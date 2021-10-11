import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

class PlacedOrderQueueTest {
    PlacedOrderQueue queue;
    Order orderOne;
    Order orderTwo;

    @Before
    public void setUp() {
        queue = new PlacedOrderQueue();
        orderOne = new Order(1, (List<Dish>) new Dish("a", 1, new String[]{"a", "b"}, 0));
        orderTwo = new Order(1, (List<Dish>) new Dish("a", 1, new String[]{"a", "b"}, 0));
    }

    @Test(timeout = 50)
    public void TestAddOrderSingleAdd() {
        assertTrue(queue.addOrder(orderOne));
    }

    @Test(timeout = 50)
    public void TestAddOrderMultipleAdd() {
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderTwo));
    }

    @Test(timeout = 50)
    public void TestGetNextOrderSingleNext() {
        assertEquals(null, queue.getNextOrder());
        assertTrue(queue.addOrder(orderOne));
        assertEquals(orderOne, queue.getNextOrder());
        assertTrue(queue.addOrder(orderTwo));
        assertEquals(orderTwo, queue.getNextOrder());
    }

    @Test(timeout = 50)
    public void TestGetNextOrderMultipleNext() {
        assertNull(queue.getNextOrder());
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderOne));
        assertEquals(orderOne, queue.getNextOrder());
        assertTrue(queue.addOrder(orderTwo));
        assertNotEquals(orderTwo, queue.getNextOrder());
        assertNotEquals(orderTwo, queue.getNextOrder());
        assertEquals(orderTwo, queue.getNextOrder());
    }
}