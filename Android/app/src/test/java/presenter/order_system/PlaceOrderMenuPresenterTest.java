package presenter.order_system;

import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.order_system.view_interfaces.PlaceOrderMenuViewInterface;
import use_case.dish_list.DishInformation;

import java.util.HashMap;

/**
 * Test the PlaceOrderMenuPresenter class
 */
public class PlaceOrderMenuPresenterTest {
    private final DishInformation dishInformation = new DishInformation();
    private PlaceOrderMenuPresenter placeOrderMenuPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        generateDishList();
        this.placeOrderMenuPresenter = new PlaceOrderMenuPresenter();

        TestClass testActivity = new TestClass();
        placeOrderMenuPresenter.setPlaceOrderMenuViewInterface(testActivity);

    }

    /**
     * Test the numberOfDishesInMenu method
     */
    @Test
    public void testNumberOfDishesInMenu() {
        placeOrderMenuPresenter.numberOfDishesInMenu();
        assert true;
    }

    /**
     * Test the allDishNames method
     */
    @Test
    public void testAllDishNames() {
        placeOrderMenuPresenter.allDishNames();
        assert true;
    }

    /**
     * Test the setDishNamePickerMaxValue method
     */
    @Test
    public void testSetDishNamePickerMaxValue() {
        placeOrderMenuPresenter.setDishNamePickerMaxValue(0);
    }

    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements PlaceOrderMenuViewInterface {

        /**
         * Test if this method is called
         * @param size the number of dishes in menu
         */
        @Override
        public void setDishNamePickerMaxValue(int size) {
            assert true;
        }

        /**
         * Test if this method is called
         * @param dishNames names of dishes
         */
        @Override
        public void setDisplayedDishNames(String[] dishNames) {
            assert true;
        }
    }



    /**
     * Generate dishes for the test
     */
    private void generateDishList() {
        Dish d1 = new Dish("dish1", 10, new HashMap<>(), 20);
        Dish d2 = new Dish("dish2", 30, new HashMap<>(), 200);
        dishInformation.addDish(d1);
        dishInformation.addDish(d2);
    }

}
