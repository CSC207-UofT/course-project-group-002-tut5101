package use_case.deliver_order;

import entity.order.DeliveryOrder;
import entity.order.Order;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayDeque;
import java.util.HashMap;

public class DeliveryBufferTest {
    private Order testOrder;

    /**
     * Set up the test
     */
    @Before
    public void setUp() {
        DeliveryBuffer.setDeliveryBuffer(new ArrayDeque<>());
        testOrder = new DeliveryOrder("1", new HashMap<>());
    }

    /**
     * test to get a delivery order
     * @throws Exception When there is no order, throw exception
     */
    @Test
    public void getDeliveryOrder() throws Exception {
        DeliveryBuffer.addDeliveryOrder(testOrder);
        assertEquals(testOrder, DeliveryBuffer.getDeliveryOrder());
    }

    /**
     * Test to add a delivery order to the buffer
     */
    @Test
    public void addDeliveryOrder() {
        DeliveryBuffer.addDeliveryOrder(testOrder);
    }

    /**
     * Test to reset the buffer
     */
    @Test
    public void testReset() {
        DeliveryBuffer.reset();
    }
}