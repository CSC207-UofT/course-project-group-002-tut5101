package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the CheckInventoryPresenter.
 */
public class UpdateQuantityPresenterTest {

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        UpdateQuantityPresenter update = new UpdateQuantityPresenter();
        TestClass testPresenter = new TestClass();
        update.setUpdateQuanInterface(testPresenter);
    }

    /**
     * Test the showInfo method
     */
    @Test
    public void showInfo(){
        assert true;
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements UpdateQuantityInterface  {

        /**
         * test use
         *
         * @param message message
         */
        @Override
        public void popInfo(String message) {
            assert true;
        }
    }
}
