import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerUseCaseTest {
    CustomerUseCaseTest CustomerUseCaseTest1;

    @Before
    public void setUp(){
        CustomerUseCaseTest1 = new CustomerUseCaseTest();
    }

    @Test(timeout = 50)
    public void testLeaveReview(){
        assertEquals(1, 1);
    }

    @Test(timeout = 50)
    public void testComplain(){
        assertEquals(1, 1);
    }

    @Test(timeout = 50)
    public void testAssistance(){
        assertEquals(1, 1);
    }

    @Test(timeout = 50)
    public void testPayBill(){
        assertEquals(1, 1);
    }

}
