package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;
import presenter.inventory_system.view_interfaces.CheckInventoryInterface;

/**
 * Testing the CheckInventoryPresenter.
 */
public class CheckInventoryPresenterTest {
    private CheckInventoryPresenter check;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        check = new CheckInventoryPresenter();
        TestClass testPresenter = new TestClass();
        check.setCheckInventoryInterface(testPresenter);
    }

    /**
     * Test the checkValidity method
     */
    @Test
    public void checkValidity(){
        check.checkValidity("1");
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements CheckInventoryInterface {

        /**
         * test use
         *
         * @param info information.
         */
        @Override
        public void CheckValidity(String info) {
            assert true;
        }
    }
}
