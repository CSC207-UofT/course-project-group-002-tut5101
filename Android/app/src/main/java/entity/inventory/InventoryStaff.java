package entity.inventory;

import entity.delivery.Staff;

/**
 * Entity class for inventory staff.
 */


public class InventoryStaff extends Staff {
    /**
     * Construct an instance of Inventory Staff
     * @param staffID The id of the staff
     * @param staffName The name of the staff
     * @param password the password of the staff
     */
    public InventoryStaff(String staffID, String staffName, String password) {
        super(staffID, staffName, password);
    }
}
