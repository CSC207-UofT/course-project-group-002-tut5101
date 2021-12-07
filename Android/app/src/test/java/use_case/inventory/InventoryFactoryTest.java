package use_case.inventory;

import entity.inventory.HasExpiryDate;
import entity.inventory.HasFreshness;
import entity.inventory.Inventory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the InventoryFactory class
 */
public class InventoryFactoryTest {
    private InventoryFactory inventoryFactory;
    private HasFreshness hasFreshness;
    private HasExpiryDate hasExpiryDate;

    private String[] freshInfo;
    private String[] expiryInfo;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        inventoryFactory = new InventoryFactory();

        hasFreshness = new HasFreshness("Test", 40.0, 20, "Fresh", 20220731);
        hasExpiryDate = new HasExpiryDate("Test", 40.0, 20, 20220731);

        freshInfo = new String[]{"Test", "40.0", "20", "Fresh", "20220731"};
        expiryInfo = new String[]{"Test", "40.0", "20", "20220731"};
    }

    /**
     * Test the getInventory method
     */
    @Test
    public void testGetInventory() {
        Inventory actual1 = inventoryFactory.getInventory(freshInfo);
        Inventory actual2 = inventoryFactory.getInventory(expiryInfo);
        assertEquals(hasFreshness, actual1);
        assertEquals(hasExpiryDate, actual2);
        assertNull(inventoryFactory.getInventory(new String[]{}));
    }
}
