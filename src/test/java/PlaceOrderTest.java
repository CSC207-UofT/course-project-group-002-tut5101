/**
 * Test for the PlaceOrder class
 */

import entity.Dish;
import entity.Order;
import org.junit.Before;
import org.junit.Test;
import use_case.DishList;
import use_case.OrderQueue;
import use_case.PlaceOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {
    private static List<Dish> menu = null;
    private PlaceOrder placeOrder = new PlaceOrder();
    private DishList dishList;

    Dish quarterPoundWithCheese;
    Dish smallFries;
    Dish coke;

    @Before
    public void setUp() {
        menu = generateDishList();
        dishList = new DishList(menu);

    }

    @Test
    public void testGenerateDishCopy() {
        Dish quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food");
        Dish dishCopy = placeOrder.generateDishCopy("Quarter pound with cheese", "None", false);

        assert(quarterPoundWithCheese.equals(dishCopy));
    }



    /**
     * Test placing a dine in order with table number
     */
    @Test(timeout = 50)
    public void testPlaceOrderDineInTrue(){
        String[] dishNames = new String[]{"Quarter pound with cheese", "Small fries", "Coke"};
        String location = "1";

        try{
            placeOrder.placeOrder(true, dishNames, location);
        } catch (Exception ignored) {
        }
        quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food");
        smallFries = new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food");
        coke = new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink");

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", List.of(new Dish[]{quarterPoundWithCheese}));
        dishes.put("Small fries", List.of(new Dish[]{smallFries}));
        dishes.put("Coke", List.of(new Dish[]{coke}));

        quarterPoundWithCheese.setTableNum(1);
        smallFries.setTableNum(1);
        coke.setTableNum(1);

        Order order = new Order(1, dishes);

        assert(order.equals(OrderQueue.getNextOrder()));
    }



    /**
     * Test placing a delivery order with table number
     */
    @Test(timeout = 50)
    public void testPlaceOrderDineInFalse(){
        String[] dishNames = new String[]{"Quarter pound with cheese", "Small fries", "Coke"};
        String location = "Toronto, ON";

        try{
            placeOrder.placeOrder(false, dishNames, location);
        } catch (Exception ignored) {
        }

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", List.of(new Dish[]{new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food")}));
        dishes.put("Small fries", List.of(new Dish[]{new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food")}));
        dishes.put("Coke", List.of(new Dish[]{new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink")}));
        Order order = new Order(location, dishes);

        assert(order.equals(OrderQueue.getNextOrder()));
    }




    public static ArrayList<Dish> generateDishList() {
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food"));
        dishes.add(new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food"));
        dishes.add(new Dish("Median fries", 2.50, new HashMap<>(), 250, "Food"));
        dishes.add(new Dish("Large fries", 3.25, new HashMap<>(), 350, "Food"));
        dishes.add(new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink"));
        dishes.add(new Dish("Coffee", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
        dishes.add(new Dish("Tea", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
        return dishes;
    }
}
