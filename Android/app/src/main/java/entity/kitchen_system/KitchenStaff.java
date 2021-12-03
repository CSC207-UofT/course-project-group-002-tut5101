package entity.kitchen_system;

import entity.delivery_system.Staff;

/**
 * Entity class for kitchen.
 */


public class KitchenStaff extends Staff {
    public KitchenStaff(String staffID, String staffName, String password) {
        super(staffID, staffName, password);
    }
}
