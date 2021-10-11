/**
 * Tests for ServingStaff class
 * By Dedong Xie
 * 2021-10-11
 */
/*
This is used to test the functionality of serving staff.
Assume that Kitchen is implemented properly.
 */
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.*;

public class ServingStaffTest {
    ServingStaff servingStaff;

    @Before
    void setUp() {
        servingStaff = new ServingStaff("a", 1, 10);
    }

    @Test(timeout = 50)
    void TestServeDish() {
        assertFalse(servingStaff.serveDish());
        Kitchen.servingBuffer.add(new DishInfo(1, new Dish("1", 10, new String[]{"1", "2"}, 10)));
        assertTrue(servingStaff.serveDish());
    }
}