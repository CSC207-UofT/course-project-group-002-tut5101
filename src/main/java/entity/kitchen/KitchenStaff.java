package entity.kitchen;

import entity.delivery.Staff;

/**
 * Entity class for kitchen.
 */


public class KitchenStaff extends Staff {
    public KitchenStaff(String staffID, String staffName, String password, int staffSalary) {
        super(staffID, staffName, password, staffSalary);
    }
}
