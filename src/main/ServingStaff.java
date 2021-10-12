/**
 * Class of a serving staff that checks the queue of dishes to be delivered and deliver the dishes
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

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

    /**
     * Let a serving staff to get a dish to be served and serve a dish to the table
     * @return Return true when serve success, otherwise return false
     */
    public boolean serveDish() {
        try {
            DishInfo dishToBeServed = Kitchen.getServingDish();
            dishToBeServed.getDish().setStatus("served");
        } catch (Exception e) {
            System.out.println("No dish to be served, serving list empty." + e.getMessage());
            return false;
        }
        return true;
    }

}
