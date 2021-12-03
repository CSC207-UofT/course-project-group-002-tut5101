package presenter.customersystem;

import org.junit.Before;
import org.junit.runners.model.TestClass;
import presenter.managersystem.ManageMenuPresenter;
import presenter.managersystem.ManageMenuPresenterTest;
import presenter.managersystem.ManageMenuViewInterface;
import presenter.menusystem.DisplayMenuViewInterface;
import presenter.menusystem.MenuPresenter;
import use_case.dishlist.DishList;

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
