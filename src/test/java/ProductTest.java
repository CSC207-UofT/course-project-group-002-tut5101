import entities.Alcohol;
import entities.Product;
import entities.SemiFinished;
import entities.SoftDrink;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductTest {
    Product alcohol;
    Product semi;
    Product soft;

    @Before
    public void setUp(){
        alcohol = new Alcohol("a",6.66,7.0,20211213);
        semi = new SemiFinished("b",7.77,8.5,20211211);
        soft = new SoftDrink("c",8.88,9.0,20211022);

    }

    @Test(timeout = 50)
    public void testgetExpiryDate(){
        assertEquals(20211213, alcohol.getExpiryDate());
        assertEquals(20211211, semi.getExpiryDate());
        assertEquals(20211022, soft.getExpiryDate());

    }

    @SuppressWarnings("deprecation")
    @Test(timeout = 50)
    public void testgetQuantity(){
        assertEquals(7.0, alcohol.getQuantity());
        assertEquals(8.5, semi.getQuantity());
        assertEquals(9.0, soft.getQuantity());
    }

    @Test(timeout = 50)
    public void testgetUsedup(){
        assertFalse(alcohol.getUsedup());
        assertFalse(semi.getUsedup());
        assertFalse(soft.getUsedup());
    }
    @SuppressWarnings("deprecation")
    @Test(timeout = 50)
    public void testupdateQuantity(){
        assertTrue(alcohol.updateQuantity(3.0));
        assertFalse(semi.updateQuantity(9.0));
        assertTrue(soft.updateQuantity(9.0));
        assertFalse(alcohol.getUsedup());
        assertFalse(semi.getUsedup());
        assertTrue(soft.getUsedup());
        assertEquals(4.0, alcohol.getQuantity());
        assertEquals(8.5, semi.getQuantity());
        assertEquals(0.0, soft.getQuantity());
    }











}
