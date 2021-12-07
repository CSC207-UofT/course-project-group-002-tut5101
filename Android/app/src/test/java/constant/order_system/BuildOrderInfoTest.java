package constant.order_system;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class BuildOrderInfoTest {
    Object o;
    /**
     * Set the build order information
     */
    @Before
    public void setUp() {
        o = BuildOrderInfo.CREATOR;
    }
    /**
     * Test the existence of info
     */
    @Test
    public void values() {
        BuildOrderInfo[] values = BuildOrderInfo.values();
        assertNotNull(values);
    }
    /**
     * Test order types
     */
    @Test
    public void valueOf() {
        BuildOrderInfo.valueOf("ORDER_TYPE");
    }
}