package use_case;

import entity.DeliveryStaff;
import entity.Dish;
import entity.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DeliverOrderTest {
    DeliverOrder deliver;

    @Before
    public void setUp() throws Exception {
        deliver = new DeliverOrder();
        Order order1 = new Order("1", new HashMap<>());
        DeliveryBuffer.addDeliveryOrder(order1);
        UserList.addUser(new DeliveryStaff("1", "a", "abc", 10));
    }

    @Test
    public void getToBeDeliver() {
        try {
            deliver.getToBeDeliver("1");
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void display() {
        try {
            deliver.getToBeDeliver("1");
            String target = "ORDER DETAILS\n" +
                    "------------------------------\n" +
                    "Total Price: $0.0";
            assertEquals(target, deliver.display("1"));
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void delivered() {
        try {
            deliver.getToBeDeliver("1");
            deliver.delivered("1");
        } catch (Exception e) {
            assert false;
        }
    }
}