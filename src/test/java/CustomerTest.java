import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer1;
    Customer customer2;

    @Before
    public void setUp(){
        customer1 = new Customer();
        customer2 = new Customer("2", "NaiHe", "20211011");
    }

    @Test(timeout = 50)
    public void TestCustomerConstructor1(){
        assertEquals(customer1.getId(), "you");
        assertEquals(customer1.getName(), "123");
        assertEquals(customer1.getPassword(), "12345");
    }

    @Test(timeout = 50)
    public void TestCustomerConstructor2(){
        assertEquals(customer2.getId(), "2");
        assertEquals(customer2.getName(), "NaiHe");
        assertEquals(customer2.getPassword(), "20211011");
    }

}
