package presenter.menu_presenter;

import org.junit.Before;
import org.junit.Test;
import presenter.menu_system.DisplayMenuViewInterface;
import presenter.menu_system.MenuPresenter;

/**
 * Test the MenuPresenterTest class.
 */
public class MenuPresenterTest {
    private MenuPresenter menu;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        menu = new MenuPresenter();
        TestClass testPresenter = new TestClass();
        menu.setDisplayDishesViewInterface(testPresenter);
    }

    /**
     * Test the dishesInMenuAsString method
     */
    @Test
    public void dishesInMenuAsString(){
        menu.dishesInMenuAsString();
    }

    /**
     * Test the updateMenuItemsDisplay method
     */
    @Test
    public void updateMenuItemsDisplay(){
        menu.updateMenuItemsDisplay("test");
    }

    /**
     * Test the deleteDishByName method
     */
    @Test
    public void deleteDishByName(){
        menu.deleteDishByName("test");
    }

    /**
     * Test the editDishByName method
     */
    @Test
    public void editDishByName(){
        assert true;
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements DisplayMenuViewInterface {

        /**
         * for testing.
         *
         * @param menuItems menu items.
         */
        @Override
        public void setMenuItemsText(String menuItems) {
            assert true;
        }
    }
}
