package presenter.kitchen_system;

import android.app.Activity;
import constant.file_system.FileName;
import entity.order.DineInOrder;
import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.dish_list.DishList;
import use_case.inventory.InventoryList;
import use_case.kitchen.OrderQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class KitchenPresenterTest {
    private KitchenPresenter kp;
    private HashMap<String, Integer> temp;

    @Before
    public void setUp() throws Exception {
        kp = new KitchenPresenter();
        InventoryList.setContext(new Activity());
        InventoryList.setData("TEST"+FileName.INVENTORY_FILE);
        DishList.setContext(new Activity());
        DishList.setData("TEST"+FileName.MENU_FILE);

        List<Dish> dishes1 = new ArrayList<>();
        dishes1.add(new Dish("Donut sandwich", 10.99, new HashMap<>(), 800.00));
        List<Dish> dishes2 = new ArrayList<>();
        dishes1.add(new Dish("Cheese donut", 10.99, new HashMap<>(), 800.00));
        List<Dish> dishes3 = new ArrayList<>();
        dishes1.add(new Dish("Beer milk", 10.99, new HashMap<>(), 800.00));

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Donut sandwich", dishes1);
        dishes.put("Cheese donut", dishes2);
        dishes.put("Beer milk", dishes3);

        OrderQueue.addOrder(new DineInOrder(3, dishes));

        temp = new HashMap<>();
        temp.put("Dish1", 2);
        temp.put("Dish2", 5);
        temp.put("Dish3", 2);
        temp.put("Dish4", 1);
        temp.put("Dish5", 3);
    }

    /**
     * Test the exportDishes and getNextOrder methods
     */
    @Test
    public void testExportDishes() {
        kp.getNextOrder(temp);

        ArrayList<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"Dish5", "3"});
        expected.add(new String[]{"Dish4", "1"});
        expected.add(new String[]{"Dish3", "2"});
        expected.add(new String[]{"Dish2", "5"});
        expected.add(new String[]{"Dish1", "2"});

        ArrayList<String[]> dishesDisplay = kp.exportDishes();

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i)[0], dishesDisplay.get(i)[0]);
            assertEquals(expected.get(i)[1], dishesDisplay.get(i)[1]);
        }
    }


    /**
     * Test that there is order available
     */
    @Test
    public void testCheckOrderAvailable() {
        assert kp.checkOrderAvailable();
    }

    /**
     * Test the completeDish method correctly completes a dish
     */
    @Test
    public void testCompleteDish() {
        kp.checkOrderAvailable();
        kp.completeDish("Donut sandwich");

        ArrayList<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"Cheese donut", "1"});
        expected.add(new String[]{"Beer milk", "1"});

        ArrayList<String[]> dishesDisplay = kp.exportDishes();

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i)[0], dishesDisplay.get(i)[0]);
            assertEquals(expected.get(i)[1], dishesDisplay.get(i)[1]);
        }
    }


}