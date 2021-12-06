package presenter.customer_system;

import entity.order_list.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.menu_system.DisplayMenuViewInterface;
import presenter.menu_system.MenuPresenter;
import use_case.dish_list.DishList;

import java.util.HashMap;

/**
 * Testing menu presenter.
 */
public class MenuPresenterTest {
    private MenuPresenter menuPresenter;
    private DishList dishList;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        menuPresenter = new MenuPresenter();
        TestClass testPresenter = new TestClass();
        menuPresenter.setDisplayDishesViewInterface(testPresenter);
        generateDishList();
    }

    /**
     * Generate dishes for the test
     */
    private void generateDishList() {
        dishList = new DishList();
        dishList.reset();
        Dish d1 = new Dish("dish1", 10, new HashMap<>(), 20);
        Dish d2 = new Dish("dish2", 30, new HashMap<>(), 200);
        Dish d3 = new Dish("dish3", 100, new HashMap<>(), 10);
        Dish d4 = new Dish("dish4", 10, new HashMap<>(), 20);
        Dish d5 = new Dish("dish5", 10, new HashMap<>(), 20);
        Dish d6 = new Dish("dish6", 10, new HashMap<>(), 20);
        Dish d7 = new Dish("dish7", 10, new HashMap<>(), 20);
        dishList.addDish(d1);
        dishList.addDish(d2);
        dishList.addDish(d3);
        dishList.addDish(d4);
        dishList.addDish(d5);
        dishList.addDish(d6);
        dishList.addDish(d7);
    }

    /**
     * Test the dishesInMenuAsString method
     */
    @Test
    public void dishesInMenuAsString(){
        menuPresenter.dishesInMenuAsString();
    }

    /**
     * Test the dishesInMenuAsString method
     */
    @Test
    public void updateMenuItemsDisplay(){
        menuPresenter.updateMenuItemsDisplay("dish1");
    }

    /**
     * Test the dishesInMenuAsString method
     */
    @Test
    public void deleteDishByName(){
        menuPresenter.deleteDishByName("dish2");
    }

    /**
     * Test the increasePrice method
     */
    @Test
    public void increasePrice(){
        menuPresenter.increasePrice("dish2");
    }

    /**
     * Test the decreasePrice method
     */
    @Test
    public void decreasePrice(){
        menuPresenter.decreasePrice("dish2");
    }

    /**
     * Test the decreaseCalories
     */
    @Test
    public void decreaseCalories(){
        menuPresenter.decreaseCalories("dish2");
    }

    /**
     * Test the increaseCalories
     */
    @Test
    public void increaseCalories(){
        menuPresenter.increaseCalories("dish2");
    }


    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements DisplayMenuViewInterface {

        /**
         *
         * @param menuItems menu items.
         */
        @Override
        public void setMenuItemsText(String menuItems) {
            assert true;
        }
    }




}
