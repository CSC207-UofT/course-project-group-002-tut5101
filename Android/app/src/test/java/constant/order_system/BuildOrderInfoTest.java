package constant.order_system;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildOrderInfoTest {
    Object o;

    @Before
    public void setUp() {
        o = BuildOrderInfo.CREATOR;
    }

    @Test
    public void values() {
        BuildOrderInfo[] values = BuildOrderInfo.values();
        assertNotNull(values);
    }

    @Test
    public void valueOf() {
        BuildOrderInfo.valueOf("ORDER_TYPE");
    }
}