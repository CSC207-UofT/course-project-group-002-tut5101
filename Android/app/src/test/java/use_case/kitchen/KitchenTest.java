package use_case.kitchen;

import com.example.androidgui.kitchen_activities.KitchenActivity;
import entity.order_list.DeliveryOrder;
import entity.order_list.DineInOrder;
import entity.order_list.Dish;
import entity.order_list.Order;
import org.junit.Before;
import org.junit.Test;
import presenter.kitchen_system.KitchenPresenter;
import use_case.deliver_order.DeliveryBuffer;
import use_case.deliver_order.ServingBuffer;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Test Kitchen class
 */
public class KitchenTest {

    private DineInOrder dineInOrder;
    private DeliveryOrder deliveryOrder;
    private Order sameDishOrder;
    private Kitchen kitchen;


    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        kitchen = new Kitchen(new KitchenPresenter(new KitchenActivity()));
        kitchen.reset();
        OrderQueue.reset();


        String location = "1";

        Dish quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200);
        Dish smallFries = new Dish("Small fries", 1.99, new HashMap<>(), 200);
        Dish coke = new Dish("Coke", 10.0, new HashMap<>(), 180);

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
        assertFalse(kitchen.getNextToCook());
        addOrders();
        assertTrue(kitchen.getNextToCook());
        assertFalse(kitchen.orderCompleted());
        assertTrue(kitchen.occupied());
    }

    /**
     * Test the dishAndQuantity method
     */
    @Test
    public void testDishAndQuantity() {
        addOrders();
        kitchen.getNextToCook();

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Quarter pound with cheese", 1);
        expected.put("Small fries", 1);
        expected.put("Coke", 1);

        HashMap<String, Integer> dishAndQuantity = kitchen.dishAndQuantity();

        assertEquals(expected, dishAndQuantity);
    }

    /**
     * Test the cookedDish method
     */
    @Test
    public void testCookedDish() {
        addOrders();
        kitchen.getNextToCook();
        kitchen.cookedDish("Small fries");
        Dish actualFries = null;
        try{
            actualFries = ServingBuffer.getNextToServe();
        }
        catch (Exception e) {
            assert false;
        }
        kitchen.getNextToCook();

        kitchen.cookedDish("Coke");
        kitchen.cookedDish("Small fries");
        kitchen.cookedDish("Quarter pound with cheese");

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
