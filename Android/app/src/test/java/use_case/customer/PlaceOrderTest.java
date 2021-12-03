package use_case.customer;



import entity.orderlist.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.dishlist.DishList;
import constant.ordersystem.OrderType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Test PlaceOrder class
 */
public class PlaceOrderTest {
    private PlaceOrder placeOrder;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        new DishList(generateDishList());
        placeOrder = new PlaceOrder();
    }

    /**
     * Test generateDishCopy method
     */
    @Test
    public void testGenerateDishCopy() {
        Dish quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200);
        Dish dishCopy = placeOrder.generateDishCopy("Quarter pound with cheese", "None", OrderType.DELIVERY);

        assert(quarterPoundWithCheese.equals(dishCopy));
    }



    /**
     * Test placing a Dine In order with table number
     */
    @Test(timeout = 50)
    public void testPlaceOrderDineInTrue(){
        String[] dishNames = new String[]{"Quarter pound with cheese", "Small fries", "Coke"};
        String[] dishNames2 = new String[]{"Coke", "Coke"};
        String location = "1";

        try{
            placeOrder.placeOrder(OrderType.DINE_IN, dishNames, location);
            assert true;
        } catch (Exception ignored) {
            assert false;
        }
        try{
            placeOrder.placeOrder(OrderType.DINE_IN, dishNames2, location);
            assert true;
        } catch (Exception ignored) {
            assert false;
        }
        try{
            placeOrder.placeOrder(OrderType.DINE_IN, dishNames, "blah");
            assert false;
        } catch (Exception ignored) {
            assert true;
        }
    }



    /**
     * Test placing a delivery order with table number
     */
    @Test(timeout = 50)
    public void testPlaceOrderDineInFalse(){
        String[] dishNames = new String[]{"Quarter pound with cheese", "Small fries", "Coke"};
        String location = "Toronto, ON";

        try{
            placeOrder.placeOrder(OrderType.DELIVERY, dishNames, location);
            assert true;
        } catch (Exception ignored) {
            assert false;
        }

    }



    public static ArrayList<Dish> generateDishList() {
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200));
        dishes.add(new Dish("Small fries", 1.99, new HashMap<>(), 200));
        dishes.add(new Dish("Median fries", 2.50, new HashMap<>(), 250));
        dishes.add(new Dish("Large fries", 3.25, new HashMap<>(), 350));
        dishes.add(new Dish("Coke", 10.0, new HashMap<>(), 180));
        dishes.add(new Dish("Coffee", 10.0, new HashMap<>(), 0));
        dishes.add(new Dish("Tea", 10.0, new HashMap<>(), 0));
        return dishes;
    }
}
