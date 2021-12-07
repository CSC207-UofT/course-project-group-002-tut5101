package use_case.kitchen;

import android.app.Activity;
import constant.file_system.FileName;
import entity.inventory.HasExpiryDate;
import entity.inventory.HasFreshness;
import org.junit.Test;
import use_case.inventory.InventoryFactory;
import use_case.inventory.InventoryList;
import use_case.inventory.boundary.InventoryOutputBoundary;

import static org.junit.Assert.*;


/**
 * Test the InventoryList class
 */
public class InventoryListTest {
    private InventoryList inventoryList;
    private HasExpiryDate hasExpiryDate;
    private HasFreshness hasFreshness;



    /**
     * Test the addInventory method
     */
    @Test
    public void testAddInventory() {
        inventoryList = new InventoryList();
        InventoryList.setContext(new Activity());
        InventoryList.setData("TEST"+ FileName.INVENTORY_FILE);
        hasExpiryDate = new HasExpiryDate("Test1", 40.0, 20, 20220731);
        hasFreshness = new HasFreshness("Test2", 40.0, 20, "Fresh", 20220731);

        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);
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
        inventoryList = new InventoryList();
        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);

        InventoryFactory inventoryFactory = new InventoryFactory();

        String[] freshInfo = new String[]{"Test3", "40.0", "20", "Fresh", "20220731"};
        String[] expiryInfo = new String[]{"Test4", "40.0", "20", "20220731"};

        inventoryList.addFromFactory(inventoryFactory, freshInfo);
        inventoryList.addFromFactory(inventoryFactory, expiryInfo);

        assert(inventoryList.checkExist("Test3"));
        assert(inventoryList.checkExist("Test4"));
    }

    /**
     * Test getInfo method
     */
    @Test
    public void testGetInfo() {
        inventoryList = new InventoryList();
        hasExpiryDate = new HasExpiryDate("Test1", 40.0, 20, 20220731);
        hasFreshness = new HasFreshness("Test2", 40.0, 20, "Fresh", 20220731);

        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);

        inventoryList.addInventory(hasExpiryDate);
        inventoryList.addInventory(hasFreshness);
        String expected = "Test3"+ ","+ "40.0" +
                ","+ "20" +","+ "Fresh" + "," + "20220731";
        String actual = inventoryList.getInfo("Test3");
        assertEquals(expected, actual);
    }

    /**
     * Test checkExist method
     */
    @Test
    public void testCheckExist() {
        inventoryList = new InventoryList();
        hasExpiryDate = new HasExpiryDate("Test1", 40.0, 20, 20220731);
        hasFreshness = new HasFreshness("Test2", 40.0, 20, "Fresh", 20220731);

        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);

        inventoryList.addInventory(hasExpiryDate);
        inventoryList.addInventory(hasFreshness);
        assertTrue( inventoryList.checkExist("Test1"));
        assertTrue( inventoryList.checkExist("Test2"));
        assertFalse( inventoryList.checkExist("Test6"));
    }

    /**
     * Test isHasFreshness method
     */
    @Test
    public void testIsHasFreshness() {
        inventoryList = new InventoryList();
        hasFreshness = new HasFreshness("Test2", 40.0, 20, "a", 20220731);
        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);
        inventoryList.addInventory(hasFreshness);
        assertTrue(inventoryList.isHasFreshness("Test2"));
    }

    /**
     * Test the getter and setter methods for quantity
     */
    @Test
    public void testGetSetFreshness() {
        inventoryList = new InventoryList();
        hasFreshness = new HasFreshness("Test2", 40.0, 20, "a", 20220731);
        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);
        inventoryList.addInventory(hasFreshness);
        assertTrue(inventoryList.isHasFreshness("Test2"));
        inventoryList.setFreshness("Test2","b");
        String expected = "Test2"+ ","+ "40.0" +
                ","+ "20" +","+ "b" + "," + "20220731";
        String actual = inventoryList.getInfo("Test2");
        assertEquals(expected, actual);
    }



    /**
     * Test the getter and setter methods for quantity
     */
    @Test
    public void testGetSetQuantity() {
        inventoryList = new InventoryList();
        hasExpiryDate = new HasExpiryDate("Test1", 40.0, 20, 20220731);
        inventoryList.addInventory(hasExpiryDate);
        TestClass testPresenter = new TestClass();
        inventoryList.setBoundary(testPresenter);
        assertEquals("Successfully updated",inventoryList.setQuantity("Test1",-1));
        assertEquals(21, InventoryList.getTotalQuantity("Test1"));
        assertEquals("Successfully updated",inventoryList.setQuantity("Test1",1));
        assertEquals(20, InventoryList.getTotalQuantity("Test1"));
        assertEquals("Not enough", inventoryList.setQuantity("Test1",21));
        assertEquals(20, InventoryList.getTotalQuantity("Test1"));
        assertEquals("wrong name", inventoryList.setQuantity("Test5",19));
        assertEquals("Successfully updated",inventoryList.passNewQuantityInfo("Test1",-1));
        assertEquals(21, InventoryList.getTotalQuantity("Test1"));
        assertEquals("Successfully updated",inventoryList.passNewQuantityInfo("Test1",1));
        assertEquals(20, InventoryList.getTotalQuantity("Test1"));
        assertEquals("Not enough", inventoryList.passNewQuantityInfo("Test1",21));
        assertEquals("wrong name", inventoryList.passNewQuantityInfo("Test5",19));
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