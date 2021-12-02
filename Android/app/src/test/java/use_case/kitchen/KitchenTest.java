package use_case.kitchen;

import entity.orderlist.DeliveryOrder;
import entity.orderlist.DineInOrder;
import entity.orderlist.Dish;
import entity.orderlist.Order;
import org.junit.Before;
import org.junit.Test;
import use_case.deliverorder.DeliveryBuffer;
import use_case.servedish.ServingBuffer;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Test Kitchen class
 */
public class KitchenTest {

    private DineInOrder dineInOrder;
    private DeliveryOrder deliveryOrder;
    private Order sameDishOrder;
    private Dish quarterPoundWithCheese;
    private Dish smallFries;
    private Dish coke;


    /**
     * Setup before tests
     */
    @Before
    public void setUp() {

        String location = "1";

        quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200);
        smallFries = new Dish("Small fries", 1.99, new HashMap<>(), 200);
        coke = new Dish("Coke", 10.0, new HashMap<>(), 180);

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", Collections.singletonList(quarterPoundWithCheese));
        dishes.put("Small fries", Collections.singletonList(smallFries));
        dishes.put("Coke", Collections.singletonList(coke));
        dineInOrder = new DineInOrder(Integer.parseInt(location), dishes);

        deliveryOrder = new DeliveryOrder("testing123", dishes);

        HashMap<String, List<Dish>> dishes2 = new HashMap<>();
        dishes2.put("Small fries", Arrays.asList(smallFries, smallFries));
        sameDishOrder = new DineInOrder(Integer.parseInt(location), dishes2);


    }

    private void addOrders(){
        try {
            OrderQueue.addOrder(dineInOrder);
            OrderQueue.addOrder(deliveryOrder);
            OrderQueue.addOrder(sameDishOrder);
        }
        catch (Exception ignored){

        }
    }

    /**
     * Test the getNextToCook method
     */
    @Test
    public void testGetNextToCook(){
        assertFalse(Kitchen.getNextToCook());
        addOrders();
        assertTrue(Kitchen.getNextToCook());
        assertFalse(Kitchen.orderCompleted());
        assertTrue(Kitchen.occupied());
    }

    /**
     * Test the dishAndQuantity method
     */
    @Test
    public void testDishAndQuantity() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Quarter pound with cheese", 1);
        expected.put("Small fries", 1);
        expected.put("Coke", 1);

        HashMap<String, Integer> dishAndQuantity = Kitchen.dishAndQuantity();

        assertEquals(expected, dishAndQuantity);
    }

    /**
     * Test the cookedDish method
     */
    @Test
    public void testCookedDish() {
        Kitchen.cookedDish("Small fries");
        Dish actualFries = null;
        try{
            actualFries = ServingBuffer.getNextToServe();
        }
        catch (Exception e) {
            assert false;
        }
        Kitchen.getNextToCook();

        Kitchen.cookedDish("Coke");
        Kitchen.cookedDish("Small fries");
        Kitchen.cookedDish("Quarter pound with cheese");

        Order actualOrder = null;
        try{
            actualOrder = DeliveryBuffer.getDeliveryOrder();
        }
        catch (Exception e) {
            assert false;
        }
        assertEquals("Small fries", actualFries.getName());
        assertEquals("Small fries", actualOrder.getDishes().get(0).getName());
    }



}
