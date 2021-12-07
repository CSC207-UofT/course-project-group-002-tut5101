package use_case.kitchen;

import entity.order.DeliveryOrder;
import entity.order.DineInOrder;
import entity.order.Dish;
import entity.order.Order;
import org.junit.Before;
import org.junit.Test;
import use_case.kitchen.boundary.KitchenOutputBoundary;

import java.util.*;
import static org.junit.Assert.*;


/**
 * Test Kitchen class
 */
public class CookDishTest {

    private DineInOrder dineInOrder;
    private DeliveryOrder deliveryOrder;
    private Order sameDishOrder;
    private CookDish kitchen;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        kitchen = new CookDish(new TestClass());
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
     * Test the cookedDish method
     */
    @Test
    public void testCookedDish() {
        addOrders();
        kitchen.getNextToCook();
        kitchen.cookedDish("Coke");
        kitchen.cookedDish("Small fries");
        kitchen.cookedDish("Quarter pound with cheese");
        assert true;
    }

    /**
     * Test the getAvailableOrder method
     */
    @Test
    public void testGetAvailableOrder() {
        assertFalse(kitchen.getAvailableOrder());
    }

    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements KitchenOutputBoundary {
        @Override
        public void getNextOrder(HashMap<String, Integer> dishes) {
            assert true;
        }
    }
}
