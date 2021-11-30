package entity.customer;

import entity.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for UseCase.Customer Class
 *
 * @author Chan Yu & Naihe Xiao
 */

public class CustomerTest {
    Customer customer1;
    Customer customer2;

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
        assertEquals(customer1.getId(), "defaultuserid");
        assertEquals(customer1.getName(), "Default entities.User");
        assertTrue(customer1.passwordMatches("12345"));
    }

    /**
     * test Customer constructor
     */
    @Test(timeout = 50)
    public void testCustomerConstructor2() {
        assertEquals(customer2.getId(), "2");
        assertEquals(customer2.getName(), "NaiHe");
        assertTrue(customer2.passwordMatches("12345"));
    }

    /**
     * test Customer toString method
     */
    @Test(timeout = 50)
    public void testCustomerToString() {
        String expected = "(UseCase.Customer) " + "NaiHe" + ": {" +
                "id='" + 2 + '\'' +
                ", address='" + "Toronto" + '\'' +
                ", gender='" + "N/A" + '\'' +
                ", phone='" + "12306" + '\'' +
                ", email='" + "defaultemail@gmail.com" + '\'' +
                '}';
        assertEquals(expected, customer2.toString());
    }

}
