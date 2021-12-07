package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;
import presenter.inventory_system.view_interfaces.UpdateFreshnessInterface;
import use_case.inventory.InventoryList;

import static org.junit.Assert.assertEquals;

/**
 * Testing the CheckInventoryPresenter.
 */
public class UpdateFreshnessPresenterTest {
    private UpdateFreshnessPresenter update;
    TestClass testPresenter;
    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        update = new UpdateFreshnessPresenter();
        InventoryList.setData("TESTinventory.ser");

    }

    /**
     * Test the popInfo method
     */
    @Test
    public void TestshowInfo1(){
        testPresenter = new TestClass("item does not have freshness");
        update.setUpdateFreshnessInterface(testPresenter);
        update.popInfo("Air","a");

    }

    @Test
    public void TestshowInfo2(){
        testPresenter = new TestClass("updated");
        update.setUpdateFreshnessInterface(testPresenter);
        update.popInfo("Bread","b");

    }

    @Test
    public void TestshowInfo3(){
        testPresenter = new TestClass("item does not have freshness");
        update.setUpdateFreshnessInterface(testPresenter);
        update.popInfo("Waffle","a");

    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements UpdateFreshnessInterface {

        String checkmessage;
        /**
         * The constructor for this test class
         *
         * @param info the message to compare
         */
        private TestClass(String info){checkmessage = info;}
        /**
         * test use
         *
         * @param message message
         */
        @Override
        public void popInfo(String message) {
            assertEquals(checkmessage, message);
        }
    }
}
