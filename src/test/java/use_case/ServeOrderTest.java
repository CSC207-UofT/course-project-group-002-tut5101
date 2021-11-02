package use_case;
/**
 * ServeOrder test
 * Created by Dedong Xie
 * On 2021-11-01
 */

import entity.DeliveryStaff;
import entity.Dish;
import entity.ServingStaff;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ServeOrderTest {
    ServeOrder serveStaff;

    @Before
    public void setUp() {
        serveStaff = new ServeOrder();
        Dish dish1 = new Dish("a", 10.0, new HashMap<>(), 10);
        dish1.setTableNum(10);
        ServingBuffer.addDish(dish1);
        UserList.add(new ServingStaff("2", "a", "abc", 10));
    }

    @Test
    public void getToBeDeliver() {
        try {
            serveStaff.getToBeDeliver("2");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void delivered() {
        try {
            serveStaff.getToBeDeliver("2");
            serveStaff.delivered("2");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void display() {
        try {
            serveStaff.getToBeDeliver("2");
            String target = "Table: 10 Dish: a";
            assertEquals(target, serveStaff.display("2"));
        } catch (Exception e) {
            assert false;
        }
    }
}