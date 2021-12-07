package constant.order_system;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Test order types
 */
public class OrderTypeTest {




    @Test
    public void values() {
        OrderType[] values = OrderType.values();
        assertNotNull(values);
    }

    @Test
    public void valueOf() {
        OrderType.valueOf("DINE_IN");
    }
}