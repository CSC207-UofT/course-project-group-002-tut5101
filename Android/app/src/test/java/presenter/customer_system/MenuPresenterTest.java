package presenter.customer_system;

import org.junit.Before;
import org.junit.Test;
import presenter.menu_system.MenuPresenter;
import presenter.menu_system.view_interface.DisplayMenuViewInterface;

import static org.junit.Assert.assertEquals;

/**
 * Testing menu presenter.
 */
public class MenuPresenterTest {
    private MenuPresenter menuPresenter;
    TestClass testPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        menuPresenter = new MenuPresenter();
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


}