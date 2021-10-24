package entity;


import use_case.DishInfo;

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
        this.currentDish = null;
    }

    public void setCurrentDish(DishInfo currentDish) {
        this.currentDish = currentDish;
    }

//    public void completeServingDish() throws Exception{
//        if (currentDish != null) {
//            this.currentDish.setStatus("served");
//            currentDish = null;
//        } else {
//            throw new Exception("No dish to be marked as served");
//        }
//    }
//
//
//    public int getTableNum(){
//        return this.currentDish.getTableNum();
//    }
//
//    public Dish getDish(){
//        return this.currentDish.getDish();
//    }

}
