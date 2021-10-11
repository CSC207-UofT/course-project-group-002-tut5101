/**
 * Class for Staff that hold the name, salary, and staff number of a staff
 * By Dedong xie (1006702944)
 * 2021-10-10
 */
package main;

public class Staff {
    protected String staffName;
    protected int staffNumber;
    protected int staffSalary;

    /**
     * Empty constructor to set up default staff
     */
    public Staff() {
        staffName = "";
        staffNumber = 0;
        staffSalary = 0;
    }

    /**
     * Construct a staff using the staff's name, staffNumber, and staffSalary
     * @param staffName The name of a staff
     * @param staffNumber The staff number of a staff
     * @param staffSalary The salary of a staff
     */
    public Staff(String staffName, int staffNumber, int staffSalary) {
        this.staffName = staffName;
        this.staffNumber = staffNumber;
        this.staffSalary = staffSalary;
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
     * Get the name of a staff
     * @return The name of the staff as a string.
     */
    public String getName() { return staffName;}

    /**
     * Get the staffNumber of a staff
     * @return The staffNumber of the staff as an integer.
     */
    public int getStaffNumber() { return staffNumber;}

    /**
     * Get the staffSalary, the salary of a staff
     * @return The salary of the staff
     */
    public int getStaffSalary() { return staffSalary;}
}
