package entity.inventory_system;

import entity.delivery_system.Staff;

/**
 * Entity class for inventory staff.
 */


public class InventoryStaff extends Staff {
    public InventoryStaff(String staffID, String staffName, String password) {
        super(staffID, staffName, password);
    }
}
