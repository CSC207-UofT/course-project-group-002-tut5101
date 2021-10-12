/** Test file for PlacedOrderQueue class
 * By Dedong Xie
 * 2021-10-11
 */
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlacedOrderQueueTest {
    PlacedOrderQueue queue;
    List<Dish> dishList;
    String[] ingredients;
    Order orderOne;
    Order orderTwo;

    @Before
    public void setUp() {
        queue = new PlacedOrderQueue();
        ingredients = new String[]{"a", "b"};
        dishList = new ArrayList<Dish>();
        dishList.add(new Dish("a", 10, ingredients, 100));
        dishList.add(new Dish("b", 10, ingredients, 120));
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
        Assert.assertEquals(null, queue.getNextOrder());
        assertTrue(queue.addOrder(orderOne));
        Assert.assertEquals(orderOne, queue.getNextOrder());
        assertTrue(queue.addOrder(orderTwo));
        Assert.assertEquals(orderTwo, queue.getNextOrder());
    }

    @Test(timeout = 50)
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