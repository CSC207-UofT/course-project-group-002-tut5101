import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

class PlacedOrderQueueTest {
    PlacedOrderQueue queue;
    List<Dish> dishList;
    Order orderOne;
    Order orderTwo;

    @Before
    public void setUp() {
        queue = new PlacedOrderQueue();
        dishList = (List<Dish>) new DishList();
        orderOne = new Order(1, dishList);
        orderTwo = new Order(1, dishList);
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