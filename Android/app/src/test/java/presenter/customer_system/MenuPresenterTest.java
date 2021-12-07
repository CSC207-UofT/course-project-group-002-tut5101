package presenter.customer_system;

import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.menu_system.view_interface.DisplayMenuViewInterface;
import presenter.menu_system.MenuPresenter;
import use_case.dish_list.DishList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Testing menu presenter.
 */
public class MenuPresenterTest {
    private MenuPresenter menuPresenter;
    private DishList dishList;
    TestClass testPresenter;
    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        menuPresenter = new MenuPresenter();
        dishList = new DishList();

    }

    /**
     * Test the dishesInMenuAsString method
     */
    @Test
    public void testdishesInMenuAsString(){
        testPresenter = new TestClass("");
        menuPresenter.setDisplayDishesViewInterface(testPresenter);
        menuPresenter.dishesInMenuAsString();
    }

    /**
     * Test the dishesInMenuAsString method
     */
    @Test
    public void updateMenuItemsDisplay(){
        testPresenter = new TestClass("dish1");
        menuPresenter.setDisplayDishesViewInterface(testPresenter);
        menuPresenter.updateMenuItemsDisplay("dish1");
    }


    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements DisplayMenuViewInterface {
        String checkmessage;
        /**
         * The constructor for this test class
         *
         * @param info the message to compare
         */
        private TestClass(String info){checkmessage = info;}
        /**
         *
         * @param menuItems menu items.
         */
        @Override
        public void setMenuItemsText(String menuItems) {
            assertEquals(checkmessage, menuItems);
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
        dishList.addDish(d1);
        dishList.addDish(d2);
        dishList.addDish(d3);
        dishList.addDish(d4);
        dishList.addDish(d5);
        dishList.addDish(d6);
        dishList.addDish(d7);

    }


}