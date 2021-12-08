package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;
import presenter.inventory_system.view_interfaces.CheckInventoryInterface;
import use_case.inventory.InventoryList;

import static org.junit.Assert.assertEquals;

/**
 * Testing the CheckInventoryPresenter.
 */
public class CheckInventoryPresenterTest {
    private CheckInventoryPresenter check;
    TestClass testPresenter;
    /**
     * Setup before tests
     */
    @Before
    @SuppressWarnings("SpellCheckingInspection")
    public void setUp() {
        check = new CheckInventoryPresenter();
        InventoryList.setData("TESTinventory.ser");

    }

    /**
     * Test the checkValidity method for HasFreshness
     */
    @Test
    public void checkValidity(){
        testPresenter = new TestClass("Carrot,7.0,500,a,20211123");
        check.setCheckInventoryInterface(testPresenter);
        check.checkValidity("Carrot");

    }
    /**
     * Test the checkValidity method for non-existing item
     */
    @Test
    public void checkValidity1(){
        testPresenter = new TestClass("Invalid name");
        check.setCheckInventoryInterface(testPresenter);
        check.checkValidity("Nothing");
    }
    /**
     * Test the checkValidity method for HasExpiryDate
     */
    @Test
    public void checkValidity2(){
        testPresenter = new TestClass("Waffle,9.0,500,20211205");
        check.setCheckInventoryInterface(testPresenter);
        check.checkValidity("Waffle");
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements CheckInventoryInterface {

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
        public void CheckValidity(String message) {
            assertEquals(checkMessage, message);
        }
    }
}
