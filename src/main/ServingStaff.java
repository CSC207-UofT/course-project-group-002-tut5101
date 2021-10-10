/**
 * Class of a serving staff that checks the queue of dishes to be delivered and deliver the dishes
 */
package main;

public class ServingStaff extends Staff{

    /**
     * Construct an instance of s serving staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     * @param staffSalary The salary of the staff
     */
    public ServingStaff(String staffName, int staffNumber, int staffSalary) {
        super(staffName, staffNumber, staffSalary);
    }


}
