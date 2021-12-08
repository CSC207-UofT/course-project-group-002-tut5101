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
    @SuppressWarnings("SpellCheckingInspection")
    public void setUp() {
        update = new UpdateFreshnessPresenter();
        InventoryList.setData("TESTinventory.ser");

    }

    /**
     * Test the popInfo method for non-existing item
     */
    @Test
    public void TestShowInfo1(){
        testPresenter = new TestClass("item does not have freshness");
        update.setUpdateFreshnessInterface(testPresenter);
        update.popInfo("Air","a");

    }
    /**
     * Test the popInfo method for has freshness item
     */
    @Test
    public void TestShowInfo2(){
        testPresenter = new TestClass("updated");
        update.setUpdateFreshnessInterface(testPresenter);
        update.popInfo("Bread","b");

    }
    /**
     * Test the popInfo method for has expiry date item
     */
    @Test
    public void TestShowInfo3(){
        testPresenter = new TestClass("item does not have freshness");
        update.setUpdateFreshnessInterface(testPresenter);
        update.popInfo("Waffle","a");

    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements UpdateFreshnessInterface {

        private final String checkMessage;
        /**
         * The constructor for this test class
         *
         * @param info the message to compare
         */
        private TestClass(String info){
            checkMessage = info;}
        /**
         * test use
         *
         * @param message message
         */
        @Override
        public void popInfo(String message) {
            assertEquals(checkMessage, message);
        }
    }
}
