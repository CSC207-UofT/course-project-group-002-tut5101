package entity.customer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for UseCase.Customer Class
 *
 */

public class CustomerTest {
    private Customer customer1;
    private Customer customer2;

    /**
     * setup before tests
     */
    @Before
    public void setUp() {
        customer1 = new Customer();
        customer2 = new Customer("2", "NaiHe", "12345");
    }

    /**
     * test Customer constructor
     */
    @Test(timeout = 50)
    public void testCustomerConstructor1() {
        assertEquals("defaultUserId", customer1.getId());
        assertEquals("Default entities.User", customer1.getName());
        assertTrue(customer1.passwordMatches("12345"));
    }

    /**
     * test Customer constructor
     */
    @Test(timeout = 50)
    public void testCustomerConstructor2() {
        assertEquals("2", customer2.getId());
        assertEquals("NaiHe", customer2.getName());
        assertTrue(customer2.passwordMatches("12345"));
    }

    /**
     * test Customer toString method
     */
    @Test(timeout = 50)
    public void testCustomerToString() {
        String expected = "(UseCase.Customer) " + "NaiHe" + ": {" +
                "id='" + 2 + '\'' +
                '}';
        assertEquals(expected, customer2.toString());
    }

}
