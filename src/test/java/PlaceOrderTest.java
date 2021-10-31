/**
 * Test for the PlaceOrder class
 */

import entity.Customer;
import entity.Dish;
import entity.Order;
import org.junit.Before;
import org.junit.Test;
import use_case.OrderQueue;
import use_case.PlaceOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaceOrderTest {
    private static List<Dish> menu = null;
    private PlaceOrder placeOrder;

    @Before
    public void setUp() {
        menu = generateDishList();
    }

    @Test(timeout = 50)
    public void testPlaceOrderDineInTrue(){
        boolean dineIn = true;
        String[] dishNames = new String[]{"Quarter pound with cheese", "Small fries", "Coke"};
        String location = "1";

        try{
            placeOrder.placeOrder(dineIn, dishNames, location);
        } catch (Exception ignored) {
        }

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", List.of(new Dish[]{new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food")}));
        dishes.put("Small fries", List.of(new Dish[]{new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food")}));
        dishes.put("Coke", List.of(new Dish[]{new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink")}));
        Order order = new Order(Integer.valueOf(location), dishes);

        assertEquals(order,OrderQueue.getNextOrder());

    }

    @Test(timeout = 50)
    public void testPlaceOrderDineInFalse(){
        boolean dineIn = false;
        String[] dishNames = new String[]{"Quarter pound with cheese", "Small fries", "Coke"};
        String location = "Toronto, ON";

        try{
            placeOrder.placeOrder(dineIn, dishNames, location);
        } catch (Exception ignored) {
        }

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", List.of(new Dish[]{new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food")}));
        dishes.put("Small fries", List.of(new Dish[]{new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food")}));
        dishes.put("Coke", List.of(new Dish[]{new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink")}));
        Order order = new Order(Integer.valueOf(location), dishes);

        assertEquals(order,OrderQueue.getNextOrder());
    }






    public static ArrayList<Dish> generateDishList() {
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200, "Food"));
        dishes.add(new Dish("Quarter pound with 2 cheese", 10.0, new HashMap<>(), 400, "Food"));
        dishes.add(new Dish("Quarter pound with 3 cheese", 10.0, new HashMap<>(), 500, "Food"));
        dishes.add(new Dish("Small fries", 1.99, new HashMap<>(), 200, "Food"));
        dishes.add(new Dish("Median fries", 2.50, new HashMap<>(), 250, "Food"));
        dishes.add(new Dish("Large fries", 3.25, new HashMap<>(), 350, "Food"));
        dishes.add(new Dish("Coke", 10.0, new HashMap<>(), 180, "Non-Alc Drink"));
        dishes.add(new Dish("Coffee", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
        dishes.add(new Dish("Tea", 10.0, new HashMap<>(), 0, "Non-Alc Drink"));
        dishes.add(new Dish("Milk Tea", 10.0, new HashMap<>(), 300, "Non-Alc Drink"));
        dishes.add(new Dish("Red Wine", 10.0, new HashMap<>(), 100, "Alcoholic Drink"));
        return dishes;
    }
}
