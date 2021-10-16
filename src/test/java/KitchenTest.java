import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import controller.Kitchen;
import use_case.InventoryList;
import entity.*;
import use_case.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KitchenTest {
    ServingStaff ss1;
    DeliveryStaff ds1;
    Order o1;
    Order o2;
    Order o3;
    Order o4;

    @Before
    public void setUp() throws Exception {
        ss1 = new ServingStaff("109389", "Amber", "12345", 5000);
        ds1 = new DeliveryStaff("12345", "Gale", "12345", 5000);
        HashMap<String, Double> ingredients = new HashMap<String, Double>() {{
            put("a", 10.0);
            put("b", 10.0);
        }};
        List<Dish> dishes = new ArrayList<Dish>(Arrays.asList(
                new Dish("Fries", 5.5, ingredients, 500),
                new Dish("Burger", 8.6, ingredients,
                        3000),
                new Dish("Cola", 2, ingredients,
                        3000)));
        List<Dish> dishes2 = new ArrayList<Dish>(Arrays.asList(
                new Dish("Hola", 5.5, ingredients, 500),
                new Dish("Chips", 8.6, ingredients,
                        3000),
                new Dish("Binary", 34, ingredients,
                        3000)));
        List<Dish> dishes3 = new ArrayList<Dish>(Arrays.asList(
                new Dish("Primo", 540, ingredients, 500),
                new Dish("Pizza", 23, ingredients,
                        3000),
                new Dish("Watch", 1, ingredients,
                        3000)));
        o1 = new Order(4, dishes);
        o2 = new Order("fake address 0101000", dishes);
        o3 = new Order(5, dishes2);
        o4 = new Order(5, dishes3);
        for (int i = 1; i <= 10; i++) {
            Inventory item = (Inventory) new Meat("Beef", 10.0,
                    300.0, "A", i);
            InventoryList.addInventory(item);
        }
    }

    @Test(timeout = 50)
    public void testGetServingDish() {
        DishInfo di = new DishInfo(o1.getTableNum(), o1.getDishes().get(0));
        Kitchen.servingBuffer.add(di);

        DishInfo serveDish = Kitchen.getServingDish();
        assertEquals(o1.getDishes().get(0), serveDish.getDish());
        assertEquals(o1.getTableNum(), serveDish.getTableNum());
        assertEquals(di, serveDish);
    }

    @Test(timeout = 50)
    public void testGetDeliveryDish() {
        Kitchen.deliveryBuffer.add(o2);
        Kitchen.deliveryBuffer.add(o3);
        Kitchen.deliveryBuffer.add(o4);
        assertEquals(o2, Kitchen.getDeliveryOrder());
        assertEquals(o3, Kitchen.getDeliveryOrder());
        assertEquals(o4, Kitchen.getDeliveryOrder());
    }

    @Test(timeout = 200)
    public void testCookedDish() {
        PlacedOrderQueue.addOrder(o1);
        PlacedOrderQueue.addOrder(o2);
        PlacedOrderQueue.addOrder(o3);
        PlacedOrderQueue.addOrder(o4);
        Kitchen.getNextToCook();
        for (Dish d: o1.getDishes()){
            Kitchen.cookedDish(d);
            assertEquals(d, Kitchen.getServingDish().getDish());
        }

        assertEquals(true, Kitchen.deliveryBuffer.isEmpty());

        boolean first = true;

        for (Dish d: o2.getDishes()){
            if (first){
                assertEquals(null, Kitchen.getDeliveryOrder());
                first = false;
            }
            Kitchen.cookedDish(d);
        }
        assertEquals(o2, Kitchen.getDeliveryOrder());
    }

}