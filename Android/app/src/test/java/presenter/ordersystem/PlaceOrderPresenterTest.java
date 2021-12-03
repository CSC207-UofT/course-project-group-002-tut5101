package presenter.ordersystem;

import entity.orderlist.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.dishlist.DishInformation;

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
    }

    /**
     * Test the checkRunEditOrder method
     */
    @Test
    public void testCheckRunEditOrder() {
        placeOrder.checkRunEditOrder();
    }

    /**
     * Test the updateDishesOrdered method
     */
    @Test
    public void testUpdateDishesOrdered() {
        placeOrder.updateDishesOrdered();
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
        placeOrder.passDishesOrdered(2, 5);
    }





    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements PlaceOrderViewInterface {

        /**
         * Test if this method is called
         *
         * @param displayedText dishes ordered to display
         */
        @Override
        public void displayDishesOrdered(String[] displayedText) {

        }

        /**
         * Test if this method is called
         */
        @Override
        public void orderSuccessfullyPlaced() {

        }

        /**
         * Test if this method is called
         *
         * @param message the error message to display
         */
        @Override
        public void setErrorMessage(String message) {

        }

        /**
         * Test if this method is called
         *
         * @param dishes dishes ordered
         */
        @Override
        public void setDishesOrdered(HashMap<String, Integer> dishes) {
            assertEquals(dishesOrdered, dishes);
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

        }
    }

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

