package use_case.dish_list;

import android.app.Activity;
import constant.file_system.FileName;
import entity.order.Dish;
import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;
import use_case.dish_list.boundaries.PlaceOrderMenuOutputBoundary;
import use_case.placeorder.boundaries.PlaceOrderOutputBoundary;

import java.util.HashMap;

/**
 * Test the DishInformation class
 */
public class DishInformationTest {

    private final DishInformation menu = new DishInformation(0);

    /**
     *
     * Setting up the test.
     */
    @Before
    public void setUp() {
        TestClass testPresenter = new TestClass();
        TestClass2 testPresenter2 = new TestClass2();
        DishList.setContext(new Activity());
        DishList.setData("TEST"+FileName.MENU_FILE);
        menu.setPlaceOrderOutputBoundary(testPresenter);
        menu.setPlaceOrderMenuOutputBoundary(testPresenter2);

        menu.addDish(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Quarter pound with 2 cheese", 10.0, new HashMap<>(), 400));
        menu.addDish(new Dish("Quarter pound with 3 cheese", 10.0, new HashMap<>(), 500));
        menu.addDish(new Dish("Small fries", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Median fries", 10.0, new HashMap<>(), 250));
        menu.addDish(new Dish("Large fries", 10.0, new HashMap<>(), 350));
        menu.addDish(new Dish("Coke", 10.0, new HashMap<>(), 180));
        menu.addDish(new Dish("Coffee", 10.0, new HashMap<>(), 0));
        menu.addDish(new Dish("Milk Tea", 10.0, new HashMap<>(), 300));
    }

    /**
     * Test the numberOfDishesForPresenter method
     */
    @Test
    public void testNumberOfDishesForPresenter() {
        menu.numberOfDishesForPresenter();
    }

    /**
     * Test the getAllDishNamesAsListForPresenter method
     */
    @Test
    public void testGetAllDishNamesAsListForPresenter() {
        menu.getAllDishNamesAsListForPresenter();
    }

    /**
     * Test the passDishesOrdered method
     */
    @Test
    public void testPassDishesOrdered() {
        menu.passDishesOrdered(2, 3);
    }

    /**
     * Test the dishPrice method
     */
    @Test
    public void testDishPrice() {
        menu.dishPrice("Coffee");
    }



    /**
     * Fake presenter class that implements output boundary
     */
    private static class TestClass implements PlaceOrderOutputBoundary {

        /**
         * Test if this method is called from DishInformation
         * @param dishName name of dish
         * @param dishQuantity quantity of dish
         */
        @Override
        public void updateDishesOrdered(String dishName, int dishQuantity) {
            assertEquals(3, dishQuantity);
        }

        /**
         * Test if this method is called from DishInformation
         * @param dishName name of dish
         * @param price price of dish
         */
        @Override
        public void addDishPrices(String dishName, double price) {
            assertEquals("Coffee", dishName);
            assertEquals(10.0, price, 0.1);
        }
    }
    private static class TestClass2 implements PlaceOrderMenuOutputBoundary {
        /**
         * Test if this method is called from DishInformation
         * @param size the size of the number picker
         */
        @Override
        public void setDishNamePickerMaxValue(int size) {
            assertEquals(9, size);
        }

        /**
         * Test if this method is called from DishInformation
         * @param dishNames names of dishes
         */
        @Override
        public void setDisplayedDishNames(String[] dishNames) {
            assert(dishNames.length == 9);
        }

    }

}
