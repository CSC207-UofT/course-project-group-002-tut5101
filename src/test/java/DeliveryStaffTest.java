/**
 * Test for DeliveryStaff class
 * By Dedong Xie
 * 2021-10-11
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

class DeliveryStaffTest {
    DeliveryStaff deliveryStaff;
    Order orderOne;

    @Before
    void setUp() {
        deliveryStaff = new DeliveryStaff("a", 1, 10);
        String[] ingredients = new String[]{"a", "b"};
        List<Dish> dishList = new ArrayList<Dish>();
        dishList.add(new Dish("a", 10, ingredients, 100));
        orderOne = new Order(RestaurantInfo.ADDRESS, dishList);
    }

    @Test(timeout = 50)
    void deliverOrder() {
        assertFalse(deliveryStaff.deliverOrder());
        Kitchen.deliveryBuffer.add(orderOne);
        assertTrue(deliveryStaff.deliverOrder());
    }
}