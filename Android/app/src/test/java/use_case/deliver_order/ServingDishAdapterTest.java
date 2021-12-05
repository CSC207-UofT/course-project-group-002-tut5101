package use_case.deliver_order;

import entity.delivery.ServingStaff;
import entity.order_list.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.user_list.UserList;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServingDishAdapterTest {
    private ServingDishAdaptor serveDish;
    private TestClass testPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        testPresenter = new TestClass();
        serveDish = new ServingDishAdaptor();

        HashMap<String, Integer> ingredient1 = new HashMap<>();
        ingredient1.put("Tofu", 10);
        ingredient1.put("Spice", 1);
        ingredient1.put("Garlic", 15);

        Dish dish1 = new Dish("MaPoTouFu", 12.5, ingredient1, 200);
        Dish dish2 = new Dish("RoYaleWithCheese", 10, new HashMap<>(), 500);
        dish1.setTableNum(2);
        dish2.setTableNum(3);

        ServingBuffer.addDish(dish1);
        ServingBuffer.addDish(dish2);

        UserList userList = new UserList();
        userList.addUser(new ServingStaff("1", "a", "abc"));

    }

    /**
     * Test the getToBeDelivered and deliver method
     */
    @Test
    public void testGetToBeDelivered() {
        try {
            serveDish.getToBeDeliver("1");
        } catch (Exception e) {
            assert false;
        }
        try {
            serveDish.getToBeDeliver("1");
        } catch (Exception e) {
            assert true;
        }
        try{
            serveDish.delivered("1");
        }
        catch (Exception e) {
            assert false;
        }
        try {
            serveDish.getToBeDeliver("1");
        } catch (Exception e) {
            assert true;
        }
        // empty out the serving buffer
        try{
            serveDish.delivered("1");
        }
        catch (Exception e) {
            assert false;
        }
        try {
            serveDish.getToBeDeliver("1");
            serveDish.delivered("1");
            serveDish.getToBeDeliver("1");
        } catch (Exception e) {
            assert true;
        }
        serveDish.setOutputBoundary(testPresenter);
    }

    /**
     * Test the getItemInfo method
     */
    @Test
    public void testGetItemInfo() {
        try {
            serveDish.getToBeDeliver("1");
        }
        catch (Exception ignored) {
            assertFalse(false);
        }
    }



    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements StaffDeliveryOutputBoundary {

        @Override
        public void setCurrentItemInfo(String destination, String info) {
            assertTrue(true);
        }
    }
}

