package constant.customer_system;
import org.junit.Test;

import static constant.order_system.CustomerUIMessage.*;
import static org.junit.Assert.*;

public class CustomerUIMessageTest {
    /**
     * Test whether the constants match
     */
    @Test
    public void testCustomerUIMessage () {
        assertEquals("Return to main menu", RETURN_TO_MAIN_MENU);
        assertEquals("Your order was successfully placed!", ORDER_PLACED_MESSAGE);
        assertEquals("Succeed", SUCCEED);
    }

}