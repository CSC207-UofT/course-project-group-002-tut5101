package use_case.kitchen;

import entity.inventory.HasExpiryDate;
import entity.inventory.Inventory;
import entity.orderlist.DeliveryOrder;
import entity.orderlist.DineInOrder;
import entity.orderlist.Dish;
import entity.orderlist.Order;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Test the OrderQueue class
 */
public class OrderQueueTest {
    private DineInOrder dineInOrder;
    private Order sameDishOrder;
    private Order ingredientOrder;
    private Order emptyOrder;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        Inventory hasExpiryDate = new HasExpiryDate("Potato", 40.0, 0, 20220731);
        InventoryList inventoryList = new InventoryList();
        inventoryList.addInventory(hasExpiryDate);

        String location = "1";
        HashMap<String, Integer> friesIngredients = new HashMap<>();
        friesIngredients.put("Potato", 3);

        // New order with insufficient inventory
        Dish quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, friesIngredients, 200);
        Dish smallFries = new Dish("Small fries", 1.99, friesIngredients, 200);
        Dish coke = new Dish("Coke", 10.0, new HashMap<>(), 180);

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", Collections.singletonList(quarterPoundWithCheese));
        dishes.put("Small fries", Collections.singletonList(smallFries));
        dishes.put("Coke", Collections.singletonList(coke));
        dineInOrder = new DineInOrder(Integer.parseInt(location), dishes);

        DeliveryOrder deliveryOrder = new DeliveryOrder("testing123", dishes);

        // New order with no ingredients
        HashMap<String, List<Dish>> dishes2 = new HashMap<>();
        dishes2.put("Small fries", Arrays.asList(coke, coke));
        sameDishOrder = new DineInOrder(Integer.parseInt(location), dishes2);

        // New order with sufficient inventory
        HashMap<String, List<Dish>> dishes3 = new HashMap<>();
        ingredientOrder = new DeliveryOrder("testing123", dishes3);

        // New order with no dishes
        emptyOrder = new DineInOrder(2, new HashMap<>());
    }

    @Test
    public void testAddOrder() {
        try {
            OrderQueue.addOrder(dineInOrder);
            assert false;
        }
        catch (Exception ignored) {
            assert true;
        }
        try {
            OrderQueue.addOrder(sameDishOrder);
            assert true;
        }
        catch (Exception ignored) {
            assert false;
        }

        try {
            OrderQueue.addOrder(ingredientOrder);
            assert true;
        }
        catch (Exception ignored) {
            assert false;
        }

        try {
            OrderQueue.addOrder(emptyOrder);
            assert true;
        }
        catch (Exception ignored) {
            assert false;
        }
    }


}
