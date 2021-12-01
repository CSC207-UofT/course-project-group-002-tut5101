package entity.kitchen;

import org.junit.Test;
/**
 * Test the KitchenStaff class
 */
public class KitchenStaffTest {
    /**
     * Test the constructor
     */
    @Test(timeout = 50)
    public void testConstructor() {
        new KitchenStaff("staffNumber", "staffName", "password");
    }
}
