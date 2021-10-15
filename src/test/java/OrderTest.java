import entities.Dish;
import entities.Order;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderTest {
    Order orderDineIn;
    Order orderTakeOut;

    @Before
    public void setUp() {
        List<Dish> dishList = new ArrayList<Dish>();
        HashMap<String, Double> ingredientsA = new HashMap<String, Double>() {{
            put("a", 10.0);
            put("b", 10.0);
        }};
        HashMap<String, Double> ingredientsB = new HashMap<String, Double>() {{
            put("c", 10.0);
            put("d", 10.0);
        }};
        dishList.add(new Dish("a", 10, ingredientsA, 100));
        dishList.add(new Dish("b", 5, ingredientsB, 150));
        orderDineIn = new Order(5, dishList);
        orderTakeOut = new Order("UofT", dishList);
    }

    @Test(timeout = 50)
    public void testGetOrderStatus() {
        assertTrue(orderDineIn.getOrderStatus() == "entities.Order Placed");
        assertTrue(orderTakeOut.getOrderStatus() == "entities.Order Placed");
    }

    @Test(timeout = 50)
    public void testSetOrderStatus() {
        orderDineIn.setOrderStatus("entities.Order Cooked");
        orderTakeOut.setOrderStatus("entities.Order Delivered");
        assertTrue(orderDineIn.getOrderStatus() == "entities.Order Cooked");
        assertTrue(orderTakeOut.getOrderStatus() == "entities.Order Delivered");
    }

}
