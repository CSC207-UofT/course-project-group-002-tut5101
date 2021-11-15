package entity;

import entity.Staff;

/**
 * Entity class for inventory staff.
 */


public class InventoryStaff extends Staff {
    public InventoryStaff(String staffID, String staffName, String password, int staffSalary) {
        super(staffID, staffName, password, staffSalary);
    }
}
