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

    @Before
    public void setUp() {
        DeliveryBuffer.deliveryBuffer = new ArrayDeque<>();
        testOrder = new DeliveryOrder("1", new HashMap<>());
    }

    @Test
    public void getDeliveryOrder() throws Exception {
        DeliveryBuffer.addDeliveryOrder(testOrder);
        assertEquals(testOrder, DeliveryBuffer.getDeliveryOrder());
    }

    @Test
    public void addDeliveryOrder() {
        DeliveryBuffer.addDeliveryOrder(testOrder);
    }

    @Test
    public void testReset() {
        DeliveryBuffer.reset();
    }
}