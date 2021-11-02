package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ServingStaffTest {
    ServingStaff staff;
    Dish testDish;

    @Before
    public void setUp() throws Exception {
        staff = new ServingStaff("1", "a", "bcd", 10);
        testDish = new Dish("b", 10.0, new HashMap<>(), 10.0);
        testDish.setTableNum(10);
    }

    @Test
    public void setCurrentDish() {
        try {
            staff.setCurrentDish(testDish);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void completeServingDish() {
        try {
            staff.setCurrentDish(testDish);
            staff.completeServingDish();
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void displayDish() {
        try {
            staff.setCurrentDish(testDish);
            String target = "Table: 10 Dish: b";
            assertEquals(target, staff.displayDish());
        } catch (Exception e) {
            assert false;
        }
    }
}