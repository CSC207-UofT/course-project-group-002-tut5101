/**
 * Tests for UseCase.ServingStaff class
 * By Dedong Xie
 * 2021-10-11
 */
/*
This is used to test the functionality of serving staff.
Assume that Controller.Kitchen is implemented properly.
 */

import use_case.Kitchen;
import use_case.DishInfo;
import entity.ServingStaff;
import entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ServingStaffTest {
    ServingStaff servingStaff;

    @Before
    public void setUp() {
        servingStaff = new ServingStaff("1", "a", "12345", 1000);
    }

    @Test(timeout = 50)
    public void testServeDish() {
        assertFalse(servingStaff.getServeDish());
        Kitchen.servingBuffer.add(new DishInfo(1, new Dish("1", 10, new HashMap<String, Double>(),
                10)));
        assertTrue(servingStaff.getServeDish());
    }
}