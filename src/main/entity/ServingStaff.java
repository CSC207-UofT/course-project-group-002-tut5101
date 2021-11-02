package entity;


// import use_case.DishInfo;

import constant.ItemStatus;

/**
 * Class of a serving staff that checks the queue of dishes to be delivered and deliver the dishes
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class ServingStaff extends Staff {

    private Dish currentDish;

    /**
     * Construct an instance of s serving staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     * @param staffSalary The salary of the staff
     */
    public ServingStaff(String staffNumber, String staffName, String password, int staffSalary) {
        super(staffNumber, staffName, password, staffSalary);
        this.currentDish = null;
    }


    /**
     * Set the current dish to the given dish.
     * @param currentDish The current dish for the Serving Staff
     */
    public void setCurrentDish(Dish currentDish) {
        this.currentDish = currentDish;
    }

    /**
     * Set the status of the current to "Completed" to indicate that the dish is served
     * @throws Exception if the current Dish is null.
     */
    public void completeServingDish() throws Exception{
        if (currentDish != null) {
            this.currentDish.setStatus(ItemStatus.DISH_COMPLETED);
            currentDish = null;
        } else {
            throw new Exception("No dish to be marked as served");
        }
    }

    public String displayDish(){
        if (currentDish != null){
            return "Table: " + currentDish.getTableNum() + " Dish: "+ currentDish.getName();
        }
        return "";
    }

}
