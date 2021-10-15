/**
 * Class of a serving staff that checks the queue of dishes to be delivered and deliver the dishes
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class ServingStaff extends Staff{

    private DishInfo currentDish;

    /**
     * Construct an instance of s serving staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     * @param staffSalary The salary of the staff
     */
    public ServingStaff(String staffName, int staffNumber, int staffSalary) {
        super(staffName, staffNumber, staffSalary);
    }


    public void completeDish(Dish dish){
        this.currentDish.getDish().setStatus("served");
    }

    public void getServeDish(){
        try {
            this.currentDish = Kitchen.getServingDish();
        } catch (Exception e) {
            System.out.println("No dish to be served, serving list empty." + e.getMessage());
        }
    }

    public int getTableNum(){
        return this.currentDish.getTableNum();
    }

    public Dish getDish(){
        return this.currentDish.getDish();
    }

}
