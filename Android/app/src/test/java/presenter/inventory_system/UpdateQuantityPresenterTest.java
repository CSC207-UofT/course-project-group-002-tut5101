package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;
import presenter.inventory_system.view_interfaces.UpdateQuantityInterface;
import use_case.inventory.InventoryList;

import static org.junit.Assert.*;
/**
 * Testing the CheckInventoryPresenter.
 */
public class UpdateQuantityPresenterTest {
    UpdateQuantityPresenter update;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        update = new UpdateQuantityPresenter();
        InventoryList.setData("TESTinventory.ser");

    }

    /**
     * Test the showInfo method
     */
    @Test
    public void TestshowInfo1(){
        TestClass testView = new TestClass("wrong name");
        update.setUpdateQuanInterface(testView);
        update.showInfo("Air","1");

    }

    @Test
    public void TestshowInfo2(){
        TestClass testView = new TestClass("Not enough");
        update.setUpdateQuanInterface(testView);
        update.showInfo("Carrot","10000000");

    }

    @Test
    public void TestshowInfo3(){
        TestClass testView = new TestClass("Successfully updated");
        update.setUpdateQuanInterface(testView);
        update.showInfo("Carrot","-1");

    }
    /**
     * Test the getMessage method
     */
    @Test
    public void TestgetMessage(){
        String message = "11";
        assertEquals(message,update.getMessage(message));
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements UpdateQuantityInterface {
        String checkmessage;

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
