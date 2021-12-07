package entity.delivery;

import entity.order.DeliveryOrder;
import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test the DeliveryStaff class
 */
public class DeliveryStaffTest {
    private DeliveryStaff deliveryStaff;
    private DeliveryOrder deliveryOrder;

    /**
     * Run before the tests
     */
    @Before
    public void setUp() {
        deliveryStaff = new DeliveryStaff("staffNumber", "staffName", "password");

        Dish quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200);
        Dish smallFries = new Dish("Small fries", 1.99, new HashMap<>(), 200);
        Dish coke = new Dish("Coke", 10.0, new HashMap<>(), 180);

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", Collections.singletonList(quarterPoundWithCheese));
        dishes.put("Small fries", Collections.singletonList(smallFries));
        dishes.put("Coke", Collections.singletonList(coke));

        deliveryOrder = new DeliveryOrder("testing123", dishes);
    }

    /**
     * Test setting DeliveryStaff current order and checking if DeliveryStaff has order
     */
    @Test(timeout = 50)
    public void testSetHasCurrentOrder() {
        boolean before = deliveryStaff.hasCurrentOrder();
        deliveryStaff.setCurrentOrder(deliveryOrder);
        boolean after = deliveryStaff.hasCurrentOrder();
        assertFalse(before);
        assertTrue(after);
    }

    /**
     * Test completeOrderDelivery method when there is no order and when there is an order
     */
    @Test(timeout = 50)
    public void testCompleteOrderDelivery() {
        setUp();
        try {
            deliveryStaff.completeOrderDelivery();
        }
        catch (Exception e) {
            assertFalse(false);
        }

        deliveryStaff.setCurrentOrder(deliveryOrder);
        boolean before = deliveryStaff.hasCurrentOrder();

        try {
            deliveryStaff.completeOrderDelivery();
        }
        catch (Exception e) {
            fail();
        }

        boolean after = deliveryStaff.hasCurrentOrder();

        assertTrue(before);
        assertFalse(after);

    }

    /**
     * Test displayOrder method
     */
    @Test(timeout = 50)
    public void testDisplayOrder() {
        setUp();
        String expectedNone = "";
        String actualNone = deliveryStaff.displayOrder();

        deliveryStaff.setCurrentOrder(deliveryOrder);
        String[] dishes = new String[]{"Small fries", "Coke", "Quarter pound with cheese"};
        StringBuilder content = new StringBuilder();
        content.append("Order contents: \n");
        for (String dishName : dishes) {
            content.append("\tDish: ");
            content.append(dishName);
            content.append(" Quantity: ");
            content.append(1);
            content.append("\n");
        }
        content.append("====================");

        String expected = content.toString();
        String actual = deliveryStaff.displayOrder();
        assertEquals(expectedNone, actualNone);
        assertEquals(expected, actual);
    }

    /**
     * Test the getOrderDestination method
     */
    @Test
    public void testGetOrderDestination() {
        setUp();
        String expectedNone = "";
        String actualNone = deliveryStaff.getOrderDestination();
        deliveryStaff.setCurrentOrder(deliveryOrder);
        String expected = "testing123";
        String actual = deliveryStaff.getOrderDestination();
        assertEquals(expectedNone, actualNone);
        assertEquals(expected, actual);

    }
}
