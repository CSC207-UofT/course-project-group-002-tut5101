package presenter.order_system;


import entity.order_list.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.order_system.PlaceOrderMenuPresenter;
import presenter.order_system.PlaceOrderMenuViewInterface;
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
    }

    /**
     * Test the allDishNames method
     */
    @Test
    public void testAllDishNames() {
        placeOrderMenuPresenter.allDishNames();
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
            assert(7 == size || 0 == size);
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
