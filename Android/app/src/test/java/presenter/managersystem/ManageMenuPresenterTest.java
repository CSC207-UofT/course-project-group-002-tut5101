package presenter.managersystem;


import org.junit.Before;
import org.junit.Test;

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
     * Test the getDish method
     */
    @Test
    public void testGettingDishList(){
        manager.getDishList();
    }

    /**
     * Empty fake presenter class implementing the output boundary
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
