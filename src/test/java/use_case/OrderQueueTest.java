package use_case;

import entity.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class OrderQueueTest {
    OrderQueue queue;
    Order tableOrder;
    Order addressOrder;

    @Before
    public void setUp() throws Exception {
        queue = new OrderQueue();
        tableOrder = new Order(1, new HashMap<>());
        addressOrder = new Order("a", new HashMap<>());
    }

    @Test
    public void addOrder() {
        try {
            queue.addOrder(tableOrder);
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void getNextTableOrder() {
        try {
            queue.addOrder(tableOrder);
            assertEquals(tableOrder, queue.getNextOrder());
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void getNextAddressOrder() {
        try {
            queue.addOrder(addressOrder);
            assertEquals(addressOrder, queue.getNextOrder());
        } catch (Exception e) {
            assert false;
        }
    }
}