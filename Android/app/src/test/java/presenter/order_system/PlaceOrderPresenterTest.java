package presenter.order_system;

import constant.order_system.OrderType;
import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.order_system.view_interfaces.PlaceOrderViewInterface;
import use_case.dish_list.DishInformation;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Test the PlaceOrderPresenter class
 */
public class PlaceOrderPresenterTest {
    private PlaceOrderPresenter placeOrder;
    private final DishInformation dishInformation = new DishInformation();
    private static HashMap<String, Integer> dishesOrdered;
    private static HashMap<String, Double> dishPrices;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        generateDishList();
        placeOrder = new PlaceOrderPresenter();
        TestClass testActivity = new TestClass();
        placeOrder.setPlaceOrderViewInterface(testActivity);

        dishesOrdered = new HashMap<>();
        dishesOrdered.put("dish1", 3);
        dishesOrdered.put("dish2", 1);
        placeOrder.setDishesOrdered(dishesOrdered);

        dishPrices = new HashMap<>();
        dishPrices.put("dish1", 10.0);
        dishPrices.put("dish2", 30.0);
        placeOrder.setDishPrices(dishPrices);
    }

    /**
     * Test the checkRunEditOrder method
     */
    @Test
    public void testCheckRunEditOrder() {
        placeOrder.checkRunEditOrder();
        dishesOrdered = new HashMap<>();
        placeOrder.setDishesOrdered(dishesOrdered);
        placeOrder.checkRunEditOrder();
    }

    /**
     * Test the updateDishesOrderedInView method
     */
    @Test
    public void testUpdateDishesOrderedInView() {
        placeOrder.updateDishesOrderedInView();
    }

    /**
     * Test the updateDishPrices method
     */
    @Test
    public void testUpdateDishPrices() {
        placeOrder.updateDishPrices();
    }


    /**
     * Test the passDishesOrdered method
     */
    @Test
    public void testPassDishesOrdered() {
        placeOrder.passDishesOrdered(3, 5);
    }

    /**
     * Test the addDishPrice method
     */
    @Test
    public void testAddDishPrice() {
        placeOrder.addDishPrices("dish3", 100);
    }

    /**
     * Test the updateDishesOrdered method
     */
    @Test
    public void testUpdateDishesOrdered() {
        placeOrder.updateDishesOrdered("dish4", 1);
    }


    /**
     * Test the displayDishesOrdered method
     */
    @Test
    public void testDisplayDishesOrdered() {
        placeOrder.displayDishesOrdered();
    }

    /**
     * Test the runPlaceOrderInformation method
     */
    @Test
    public void testRunPlaceOrderInformation() {
        placeOrder.runPlaceOrderInformation(OrderType.DINE_IN, "1");
        placeOrder.runPlaceOrderInformation(OrderType.DINE_IN, "blah");
    }



    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements PlaceOrderViewInterface {

        /**
         * Test if this method is called
         *
         * @param displayedText dishes ordered displaying
         */
        @Override
        public void displayDishesOrdered(String[] displayedText) {
            assert true;
        }

        /**
         * Test if this method is called
         */
        @Override
        public void orderSuccessfullyPlaced() {
            assert true;
        }

        /**
         * Test if this method is called
         *
         * @param message the error message to display
         */
        @Override
        public void setErrorMessage(String message) {
            assert true;
        }

        /**
         * Test if this method is called
         *
         * @param dishes dishes ordered
         */
        @Override
        public void setDishesOrdered(HashMap<String, Integer> dishes) {
            assert true;
        }

        /**
         * Test if this method is called
         *
         * @param prices prices of dishes
         */
        @Override
        public void setDishPrices(HashMap<String, Double> prices) {
            assertEquals(dishPrices, prices);
        }

        /**
         * Test if this method is called
         */
        @Override
        public void runEditOrder() {
            assert true;
        }
    }

    /**
     * Generate dishes for the test
     */
    private void generateDishList() {
        Dish d1 = new Dish("dish1", 10, new HashMap<>(), 20);
        Dish d2 = new Dish("dish2", 30, new HashMap<>(), 200);
        Dish d3 = new Dish("dish3", 100, new HashMap<>(), 10);
        Dish d4 = new Dish("dish4", 10, new HashMap<>(), 20);
        Dish d5 = new Dish("dish5", 10, new HashMap<>(), 20);
        Dish d6 = new Dish("dish6", 10, new HashMap<>(), 20);
        Dish d7 = new Dish("dish7", 10, new HashMap<>(), 20);
        dishInformation.addDish(d1);
        dishInformation.addDish(d2);
        dishInformation.addDish(d3);
        dishInformation.addDish(d4);
        dishInformation.addDish(d5);
        dishInformation.addDish(d6);
        dishInformation.addDish(d7);

    }
}

