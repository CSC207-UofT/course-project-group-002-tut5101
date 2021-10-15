/** Test file for UseCase.PlacedOrderQueue class
 * By Dedong Xie
 * 2021-10-11
 */
import UseCase.PlacedOrderQueue;
import entities.Dish;
import UseCase.InventoryList;
import entities.Meat;
import entities.Order;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class PlacedOrderQueueTest {
    PlacedOrderQueue queue;
    List<Dish> dishListOne;
    List<Dish> dishListTwo;
    HashMap<String, Double> ingredients;
    Order orderOne;
    Order orderTwo;

    @Before
    public void setUp() {
        queue = new PlacedOrderQueue();
        ingredients = new HashMap<String, Double>() {{
            put("a", 10.0);
            put("c", 10.0);
        }};
        dishListOne = new ArrayList<Dish>();
        dishListTwo = new ArrayList<Dish>();
        dishListOne.add(new Dish("a", 10, ingredients, 100));
        dishListTwo.add(new Dish("a", 10, ingredients, 100));
        dishListTwo.add(new Dish("b", 10, ingredients, 120));
        orderOne = new Order(1, dishListOne);
        orderTwo = new Order(2, dishListTwo);
        InventoryList.addInventory(
                new Meat("a", 1, 20.0, "fresh",0));
        InventoryList.addInventory(
                new Meat("c", 1, 20.0, "fresh",0));
    }

    @Test(timeout = 50)
    public void testAddOrderSingleAdd() {
        assertTrue(queue.addOrder(orderOne));
    }

    @Test(timeout = 50)
    public void testAddOrderMultipleAdds() {
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderOne));
        assertTrue(queue.addOrder(orderTwo));
    }

    @Test(timeout = 50)
    public void testAddOrderIngredientsUnavailable() {
        List<Dish> dishImpossible = new ArrayList<Dish>();
        HashMap<String, Double> ingredientsImpossible = new HashMap<String, Double>();
        ingredientsImpossible.put("a", 25.0);
        dishImpossible.add(new Dish("k", 10, ingredientsImpossible, 100));
        Order orderThree = new Order(1, dishImpossible);
        assertFalse(queue.addOrder(orderThree));
    }

    @Test(timeout = 50)
    public void testGetNextOrderSingleNext() {
        Assert.assertEquals(null, queue.getNextOrder());
        assertTrue(queue.addOrder(orderOne));
        Assert.assertEquals(orderOne, queue.getNextOrder());
        assertTrue(queue.addOrder(orderTwo));
        Assert.assertEquals(orderTwo, queue.getNextOrder());
    }

    @Test(timeout = 50)
    public void testGetNextOrderMultipleNext() {
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