package presenter.customer_system;

import org.junit.Before;
import org.junit.Test;
import presenter.menusystem.DisplayMenuViewInterface;
import presenter.menusystem.MenuPresenter;

/**
 * Testing menu presenter.
 */
public class MenuPresenterTest {
    private MenuPresenter menuPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        menuPresenter = new MenuPresenter();
        TestClass testPresenter = new TestClass();
        menuPresenter.setDisplayDishesViewInterface(testPresenter);
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
     * Test the dishesInMenuAsString method
     */
    @Test
    public void editDishByName(){
        menuPresenter.editDishByName("dish2");
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
