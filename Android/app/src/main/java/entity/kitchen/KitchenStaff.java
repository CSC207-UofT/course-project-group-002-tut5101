package entity.kitchen;

import entity.delivery.Staff;

/**
 * Entity class for kitchen.
 */


public class KitchenStaff extends Staff {


    /**
     * Initialize a Kitchen staff
     * @param staffID the id of this staff
     * @param staffName the name of this staff
     * @param password the login password for this staff
     */
    public KitchenStaff(String staffID, String staffName, String password) {
        super(staffID, staffName, password);
    }
}
