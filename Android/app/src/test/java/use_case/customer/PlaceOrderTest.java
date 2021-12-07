package use_case.customer;



import android.app.Activity;
import constant.file_system.FileName;
import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.dish_list.DishList;
import constant.order_system.OrderType;
import use_case.placeorder.PlaceOrder;

import java.util.HashMap;

/**
 * Test PlaceOrder class
 */
public class PlaceOrderTest {
    private PlaceOrder placeOrder;
    private final DishList menu = new DishList();

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        DishList.setContext(new Activity());
        DishList.setData("TEST"+ FileName.MENU_FILE);

        menu.addDish(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Quarter pound with 2 cheese", 10.0, new HashMap<>(), 400));
        menu.addDish(new Dish("Quarter pound with 3 cheese", 10.0, new HashMap<>(), 500));
        menu.addDish(new Dish("Small fries", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Median fries", 10.0, new HashMap<>(), 250));
        menu.addDish(new Dish("Large fries", 10.0, new HashMap<>(), 350));
        menu.addDish(new Dish("Coke", 10.0, new HashMap<>(), 180));
        menu.addDish(new Dish("Coffee", 10.0, new HashMap<>(), 0));
        menu.addDish(new Dish("Milk Tea", 10.0, new HashMap<>(), 300));

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
    @Test
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



}
