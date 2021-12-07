package presenter.user_system;


import org.junit.Before;
import org.junit.Test;
import presenter.menu_system.view_interface.ManageMenuViewInterface;
import presenter.menu_system.ManageMenuPresenter;

/**
 * Test the ManagerMenuPresenter class.
 */
public class ManageMenuPresenterTest {

    private ManageMenuPresenter manager;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        manager = new ManageMenuPresenter();
        TestClass testPresenter = new TestClass();
        manager.setManageMenuViewInterface(testPresenter);

    }

    /**
     * Test the getDish method
     */
    @Test
    public void testGetDish(){
        manager.getDish("2");
        manager.getDish("1");
    }

    /**
     * Test the getting dish list method
     */
    @Test
    public void testGettingDishList(){
        manager.getDishList();
    }

    /**
     * Test the PassingDishesAsList method
     */
    @Test
    public void testPassingDishesAsList(){
        manager.passingDishesAsList(new String[]{"good"});
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements ManageMenuViewInterface {

        /**
         * Testing use.
         * @param dishName name of the dish
         */
        @Override
        public void getDish(String dishName) {
            assert true;
        }

        /**
         * Testing use.
         * @param s array of string.
         */
        @Override
        public void gettingDishList(String[] s) {
            assert true;
        }
    }

}
