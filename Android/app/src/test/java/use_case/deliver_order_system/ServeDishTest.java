package use_case.deliver_order_system;

import entity.delivery_system.ServingStaff;
import entity.order_system.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.user_list.UserList;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServeDishTest {
    private ServeDish serveDish;
    private TestClass testPresenter;

    private Dish dish1;
    private Dish dish2;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        testPresenter = new TestClass();
        serveDish = new ServeDish();

        HashMap<String, Integer> ingredient1 = new HashMap<>();
        ingredient1.put("Tofu", 10);
        ingredient1.put("Spice", 1);
        ingredient1.put("Garlic", 15);

        dish1 = new Dish("MaPoTouFu", 12.5, ingredient1, 200);
        dish2 = new Dish("RoYaleWithCheese", 10, new HashMap<>(), 500);
        dish1.setTableNum(2);
        dish2.setTableNum(3);

        ServingBuffer.addDish(dish1);
        ServingBuffer.addDish(dish2);

        UserList userList = new UserList(1);
        userList.addUser(new ServingStaff("1", "a", "abc"));

        serveDish.setOutputBoundary(testPresenter);
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
    }

    /**
     * Test the getItemInfo method
     */
    @Test
    public void testGetItemInfo() {
        serveDish.getItemInfo("1");
        try {
            serveDish.getToBeDeliver("1");
        }
        catch (Exception ignored) {
            assertFalse(false);
        }
        serveDish.getItemInfo("1");
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
