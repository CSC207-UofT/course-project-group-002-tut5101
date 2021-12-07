package presenter.order_system;

import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.order_system.view_interfaces.EditOrderViewInterface;
import use_case.dish_list.DishInformation;


import java.util.HashMap;

/**
 * Test the EditOrderPresenter class
 */
public class EditOrderPresenterTest {
    private EditOrderPresenter editOrder;
    private final DishInformation dishInformation = new DishInformation();

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        generateDishList();
        this.editOrder = new EditOrderPresenter();
        TestClass testActivity = new TestClass();
        editOrder.setEditOrderViewInterface(testActivity);

        HashMap<String, Integer> dishesOrdered = new HashMap<>();
        dishesOrdered.put("dish1", 3);
        dishesOrdered.put("dish2", 1);
        editOrder.setDishesOrdered(dishesOrdered);

        HashMap<String, Double> dishPrices = new HashMap<>();
        dishPrices.put("dish1", 10.0);
        dishPrices.put("dish2", 30.0);
        editOrder.setDishPrices(dishPrices);
    }


    /**
     * Test the displayDishesOrdered method
     */
    @Test
    public void testDisplayDishesOrdered() {
        editOrder.displayDishesOrdered();
        editOrder.setDishesOrdered(new HashMap<>());
        editOrder.displayDishesOrdered();
    }

    /**
     * Test the removeOrderedDish method
     */
    @Test
    public void testRemoveOrderedDish() {
        editOrder.removeOrderedDish(0);
    }

    /**
     * Test the updateDishesOrdered method
     */
    @Test
    public void testUpdateDishesOrdered() {
        editOrder.collectDishes();
        editOrder.updateDishesOrdered();
    }




    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements EditOrderViewInterface {

        /**
         * Test if this method is run
         * @param dishesOrderedList ordered dishes
         */
        @Override
        public void displayDishesOrdered(String[] dishesOrderedList) {
            assert true;
        }

        /**
         *  Test if this method is run
         * @param numDishes number of dishes for picker
         */
        @Override
        public void setOrderedDishesPickerMax(int numDishes) {
            assert true;
        }

        /**
         *  Test if this method is run
         * @param dishes dishes for picker
         */
        @Override
        public void setOrderedDishesPickerValues(String[] dishes) {
            assert true;
        }

        /**
         *  Test if this method is run
         * @param dishesOrdered revised ordered dishes
         */
        @Override
        public void updateDishesOrdered(HashMap<String, Integer> dishesOrdered) {
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
