package entity.inventory;

import org.junit.Test;

/**
 * Test the InventoryStaff class
 */
public class InventoryStaffTest {
    /**
     * Test the constructor
     */
    @Test(timeout = 50)
    public void testConstructor() {
        new InventoryStaff("staffNumber", "staffName", "password");
    }
}
