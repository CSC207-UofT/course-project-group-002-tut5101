package entity.delivery;

import entity.user.User;

/**
 * Class for entities.Staff that hold the name, salary, and staff number of a staff
 * By Dedong xie (1006702944)
 * 2021-10-10
 */
@SuppressWarnings("SpellCheckingInspection")
public class Staff extends User {

    /**
     * Construct a staff using the staff's name, staffNumber, and staffSalary
     * @param staffName The name of a staff
     * @param staffID The staff number of a staff
     * @param password The password of a staff
     */
    public Staff(String staffID, String staffName, String password) {
        super(staffID, staffName, password);
    }

    /**
     *
     * Empty constructor for testing.
     */
    public Staff(){
    }

}