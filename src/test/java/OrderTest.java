
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {
    Order orderDineIn;
    Order orderTakeOut;

    @Before
    public void setUp() {
        List<Dish> dishList = new ArrayList<Dish>();
        String[] ingredientsA = new String[]{"a", "b"};
        String[] ingredientsB = new String[]{"c", "d"};
        dishList.add(new Dish("a", 10, ingredientsA, 100));
        dishList.add(new Dish("b", 5, ingredientsB, 150));
        orderDineIn = new Order(5, dishList);
        orderTakeOut = new Order("UofT", dishList);
    }

    @Test
    public void getOrderStatus() {
        assertTrue(orderDineIn.getOrderStatus() == "Order Placed");
        assertTrue(orderTakeOut.getOrderStatus() == "Order Placed");
    }

   public void setOrderStatus() {
        orderDineIn.setOrderStatus("Order Cooked");
        orderTakeOut.setOrderStatus("Order Delivered");
        assertTrue(orderDineIn.getOrderStatus() == "Order Cooked");
        assertTrue(orderTakeOut.getOrderStatus() == "Order Delivered");
    }

}
