package entity;

/**
 * DeliveryStaff test
 * Created by Dedong Xie
 * On 2021-11-01
 */

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DeliveryStaffTest {
    DeliveryStaff staff;
    Order testOrder;

    @Before
    public void setUp() throws Exception {
        staff = new DeliveryStaff("1", "a", "bbccd", 10);
        testOrder = new Order("a", new HashMap<>());
    }

    @Test
    public void setCurrentOrder() {
        try {
            staff.setCurrentOrder(testOrder);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void completeOrderDelivery() {
        try {
            staff.setCurrentOrder(testOrder);
            staff.completeOrderDelivery();
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void displayOrder() {
        try {
            staff.setCurrentOrder(testOrder);
            String target = "ORDER DETAILS\n" +
                    "------------------------------\n" +
                    "Total Price: $0.0";
            assertEquals(target, staff.displayOrder());
        } catch (Exception e) {
            assert false;
        }
    }
}