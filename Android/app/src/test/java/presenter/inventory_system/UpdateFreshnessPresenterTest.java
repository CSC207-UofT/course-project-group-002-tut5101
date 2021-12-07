package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;
import presenter.inventory_system.view_interfaces.UpdateFreshnessInterface;

/**
 * Testing the CheckInventoryPresenter.
 */
public class UpdateFreshnessPresenterTest {
    private UpdateFreshnessPresenter update;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        update = new UpdateFreshnessPresenter();
        TestClass testPresenter = new TestClass();
        update.setUpdateFreshnessInterface(testPresenter);
    }

    /**
     * Test the popInfo method
     */
    @Test
    public void popInfo(){
        update.popInfo("1","2");
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements UpdateFreshnessInterface {

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
