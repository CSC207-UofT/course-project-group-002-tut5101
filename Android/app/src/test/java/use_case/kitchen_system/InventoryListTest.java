package use_case.kitchen_system;

import entity.inventory_system.HasExpiryDate;
import entity.inventory_system.HasFreshness;
import org.junit.Before;
import org.junit.Test;
import use_case.inventory_system.InventoryFactory;
import use_case.inventory_system.InventoryOutputBoundary;

import static org.junit.Assert.*;


/**
 * Test the InventoryList class
 */
public class InventoryListTest {
    private InventoryList inventoryList;
    private HasExpiryDate hasExpiryDate;
    private HasFreshness hasFreshness;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        inventoryList = new InventoryList();
        hasExpiryDate = new HasExpiryDate("Test1", 40.0, 20, 20220731);
        hasFreshness = new HasFreshness("Test2", 40.0, 20, "Fresh", 20220731);

        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);
    }

    /**
     * Test the addInventory method
     */
    @Test
    public void testAddInventory() {
        inventoryList.addInventory(hasExpiryDate);
        inventoryList.addInventory(hasFreshness);

        assert(inventoryList.checkExist("Test1"));
        assert(inventoryList.checkExist("Test2"));
    }

    /**
     * Test the addFromFactory method
     */
    @Test
    public void testAddFromFactory() {
        InventoryFactory inventoryFactory = new InventoryFactory();

        String[] freshInfo = new String[]{"Test1", "40.0", "20", "Fresh", "20220731"};
        String[] expiryInfo = new String[]{"Test2", "40.0", "20", "20220731"};

        inventoryList.addFromFactory(inventoryFactory, freshInfo);
        inventoryList.addFromFactory(inventoryFactory, expiryInfo);

        assert(inventoryList.checkExist("Test1"));
        assert(inventoryList.checkExist("Test2"));
    }

    /**
     * Test getInfo method
     */
    @Test
    public void testGetInfo() {
        inventoryList.addInventory(hasExpiryDate);
        inventoryList.addInventory(hasFreshness);
        String expected = "Test1"+ ","+ "40.0" +
                ","+ "20" +","+ "20220731";
        String actual = inventoryList.getInfo("Test1");
        assertEquals(expected, actual);
    }

    /**
     * Test isHasFreshness method
     */
    @Test
    public void testIsHasFreshness() {
        inventoryList.addInventory(hasFreshness);
        assertTrue(inventoryList.isHasFreshness("Test2"));
    }


    /**
     * Test the getter and setter methods for quantity
     */
    @Test
    public void testGetSetQuantity() {
        assertEquals(0, InventoryList.getTotalQuantity("Test1"));
        inventoryList.addInventory(hasFreshness);
        assertEquals(20, InventoryList.getTotalQuantity("Test2"));
        assertEquals("wrong name", inventoryList.setQuantity("Test1", 20));
        assertEquals("Successfully updated", inventoryList.setQuantity("Test2", 10));
    }

    /**
     * Fake presenter class that implements output boundary
     */
    private static class TestClass implements InventoryOutputBoundary {

        /**
         * Check if the InventoryList calls on this method
         * @param message the message to display
         * @return the message
         */
        @Override
        public String getMessage(String message) {
            assert(true);
            return message;
        }
    }
}
