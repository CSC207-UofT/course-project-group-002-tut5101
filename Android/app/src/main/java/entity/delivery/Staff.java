package entity.delivery;

import entity.User;

/**
 * Class for entities.Staff that hold the name, salary, and staff number of a staff
 * By Dedong xie (1006702944)
 * 2021-10-10
 */

public class Staff extends User {
    protected int staffSalary;

    /**
     * Construct a staff using the staff's name, staffNumber, and staffSalary
     * @param staffName The name of a staff
     * @param staffID The staff number of a staff
     * @param password The password of a staff
     * @param staffSalary The salary of a staff
     */
    public Staff(String staffID, String staffName, String password, int staffSalary) {
        super(staffID, staffName, password);
        this.staffSalary = staffSalary;
    }

    /**
     *
     * Empty constructor for testing.
     */
    public Staff(){
    }

    /**
     * Increase the salary of a staff by increment
     * @param increment The value added to the current salary of a staff
     */
    public void increaseSalary(int increment) {
        staffSalary += increment;
    }

    /**
     * Reduce the salary of a staff by reduction
     * @param reduction The value added to the current salary of a staff
     */
    public void decreaseSalary(int reduction) {
        staffSalary -= reduction;
    }

    /**
     * Get the staffSalary, the salary of a staff
     * @return The salary of the staff
     */
    public int getStaffSalary() { return staffSalary;}
}