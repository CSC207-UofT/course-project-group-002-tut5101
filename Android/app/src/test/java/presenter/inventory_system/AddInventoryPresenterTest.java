package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;
import presenter.inventory_system.view_interfaces.AddInventoryViewInterface;
import use_case.inventory.InventoryList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testing the AddInventoryPresenter.
 */
public class AddInventoryPresenterTest {
    private AddInventoryPresenter add;
    TestClass testPresenter;
    /**
     * Setup before tests
     */
    @SuppressWarnings("SpellCheckingInspection")
    @Before
    public void setUp() {
        add = new AddInventoryPresenter();
        InventoryList.setData("TESTinventory.ser");
    }

    /**
     * Test the addNewInventory method for HasFreshness
     */
    @Test
    public void testAddNewInventory(){
        testPresenter = new TestClass("Successful");
        add.setAddInventoryViewInterface(testPresenter);
        add.addNewInventory("name", "2","3","4","5");
        InventoryList inventoryList = new InventoryList();
        assertTrue(inventoryList.checkExist("name"));
    }
    /**
     * Test the addNewInventory method for Has ExpiryDate
     */
    @Test
    public void testAddNewInventory1(){
        testPresenter = new TestClass("Occupied name or item");
        add.setAddInventoryViewInterface(testPresenter);
        add.addNewInventory("name", "2","3","4","N/A");
        InventoryList inventoryList = new InventoryList();
        assertTrue(inventoryList.checkExist("name"));
    }
    /**
     * Test the addNewInventory method for Existing item
     */
    @Test
    public void testAddNewInventory2(){
        testPresenter = new TestClass("Occupied name or item");
        add.setAddInventoryViewInterface(testPresenter);
        add.addNewInventory("Carrot", "2","3","4","N/A");
        InventoryList inventoryList = new InventoryList();
        assertTrue(inventoryList.checkExist("name"));
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements AddInventoryViewInterface {

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
        public void updateInventoryList(String message) {
            assertEquals(checkMessage, message);
        }
    }

}
