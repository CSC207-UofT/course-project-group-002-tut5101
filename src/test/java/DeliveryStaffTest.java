/**
 * Test for DeliveryStaff class
 * By Dedong Xie
 * 2021-10-11
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStaffTest {
    DeliveryStaff deliveryStaff;
    Order orderOne;

    @BeforeEach
    void setUp() {
        deliveryStaff = new DeliveryStaff("a", 1, 10);
        String[] ingredients = new String[]{"a", "b"};
        List<Dish> dishList = new ArrayList<Dish>();
        dishList.add(new Dish("a", 10, ingredients, 100));
        orderOne = new Order(RestaurantInfo.ADDRESS, dishList);
    }

    @Test
    void deliverOrder() {
        assertFalse(deliveryStaff.deliverOrder());
        Kitchen.deliveryBuffer.add(orderOne);
        assertTrue(deliveryStaff.deliverOrder());
    }
}