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
    @SuppressWarnings("SpellCheckingInspection")
    @Before
    public void setUp() {
        update = new UpdateQuantityPresenter();
        InventoryList.setData("TESTinventory.ser");

    }

    /**
     * Test the showInfo method for non-existing item
     */
    @Test
    public void TestShowInfo1(){
        TestClass testView = new TestClass("wrong name");
        update.setUpdateQuantityInterface(testView);
        update.showInfo("Air","1");

    }
    /**
     * Test the showInfo method for not enough usage
     */
    @Test
    public void TestShowInfo2(){
        TestClass testView = new TestClass("Not enough");
        update.setUpdateQuantityInterface(testView);
        update.showInfo("Carrot","10000000");

    }
    /**
     * Test the showInfo method for enough usage
     */
    @Test
    public void TestShowInfo3(){
        TestClass testView = new TestClass("Successfully updated");
        update.setUpdateQuantityInterface(testView);
        update.showInfo("Carrot","-1");

    }
    /**
     * Test the getMessage method
     */
    @Test
    public void TestGetMessage(){
        String message = "11";
        assertEquals(message,update.getMessage(message));
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements UpdateQuantityInterface {
        final String checkMessage;

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
