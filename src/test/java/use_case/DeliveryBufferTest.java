package use_case;
/**
 * DeliveryBuffer test
 * Created by Dedong Xie
 * On 2021-11-01
 */

import entity.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DeliveryBufferTest {
    DeliveryBuffer buffer;
    Order order1;

    @Before
    public void setUp() throws Exception {
        buffer = new DeliveryBuffer();
        order1 = new Order("address", new HashMap<>());
    }

    @Test
    public void addDeliveryOrder() {
        try {
            buffer.addDeliveryOrder(order1);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void getDeliveryOrder() {
        try {
            buffer.addDeliveryOrder(order1);
            assertEquals(order1, buffer.getDeliveryOrder());
        } catch (Exception e) {
            assert false;
        }
    }
}