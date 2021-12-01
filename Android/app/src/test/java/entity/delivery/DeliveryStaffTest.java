package entity.delivery;

import entity.orderlist.DeliveryOrder;
import entity.orderlist.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class DeliveryStaffTest {
    DeliveryStaff deliveryStaff;
    DeliveryOrder deliveryOrder;

    Dish quarterPoundWithCheese;
    Dish smallFries;
    Dish coke;

    @Before
    public void setUp() {
        deliveryStaff = new DeliveryStaff("staffNumber", "staffName", "password");

        quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200);
        smallFries = new Dish("Small fries", 1.99, new HashMap<>(), 200);
        coke = new Dish("Coke", 10.0, new HashMap<>(), 180);

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", Collections.singletonList(quarterPoundWithCheese));
        dishes.put("Small fries", Collections.singletonList(smallFries));
        dishes.put("Coke", Collections.singletonList(coke));

        deliveryOrder = new DeliveryOrder("testing123", dishes);
    }

    @Test(timeout = 50)
    public void testSetHasCurrentOrder() {
        boolean before = deliveryStaff.hasCurrentOrder();
        deliveryStaff.setCurrentOrder(deliveryOrder);
        boolean after = deliveryStaff.hasCurrentOrder();
        assertFalse(before);
        assertTrue(after);
    }

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

        String expected = "Address: " + "testing123" + "\n" + content;
        String actual = deliveryStaff.displayOrder();
        assertEquals(expectedNone, actualNone);
        assertEquals(expected, actual);
    }
}
