package entity;
/**
 * Tests for UseCase.Customer Class
 *
 * @author Chan Yu & Naihe Xiao
 */

import entity.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer1;
    Customer customer2;

    @Before
    public void setUp() {
        customer1 = new Customer();
        customer2 = new Customer("2", "NaiHe", "12345");
    }

    @Test(timeout = 50)
    public void testCustomerConstructor1() {
        assertEquals(customer1.getId(), "defaultuserid");
        assertEquals(customer1.getName(), "Default entities.User");
        assertEquals(customer1.passwordMatches("12345"), true);
    }

    @Test(timeout = 50)
    public void testCustomerConstructor2() {
        assertEquals(customer2.getId(), "2");
        assertEquals(customer2.getName(), "NaiHe");
        assertEquals(customer2.passwordMatches("12345"), true);
    }

}
