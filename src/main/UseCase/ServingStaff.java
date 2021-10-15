package UseCase;

import UseCase.DishInfo;
import UseCase.Kitchen;
import entities.*;

/**
 * Class of a serving staff that checks the queue of dishes to be delivered and deliver the dishes
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class ServingStaff extends Staff {

    private DishInfo currentDish;

    /**
     * Construct an instance of s serving staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     * @param staffSalary The salary of the staff
     */
    public ServingStaff(String staffNumber, String staffName, String password, int staffSalary) {
        super(staffNumber, staffName, password, staffSalary);
    }


    public boolean completeDish(){
        if (currentDish != null) {
            this.currentDish.getDish().setStatus("served");
            currentDish = null;
            return true;
        }
        return false;
    }

    public boolean getServeDish(){
        try {
            this.currentDish = Kitchen.getServingDish();
        } catch (Exception e) {
            //System.out.println("No dish to be served, serving list empty." + e.getMessage());
            return false;
        }
        return true;
    }

    public int getTableNum(){
        return this.currentDish.getTableNum();
    }

    public Dish getDish(){
        return this.currentDish.getDish();
    }

}
