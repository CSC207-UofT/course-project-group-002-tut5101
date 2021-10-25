package controller;

import boundary.ServingStaffControllerInterface;
import use_case.ServingBuffer;

public class ServingStaffController implements ServingStaffControllerInterface {
    String id;
    // DishInfo dish;

    public ServingStaffController(String id) {
        // TODO: add the staff
        this.id = id;
        // this.dish = null;
    }
    public void getServeDish() throws Exception {
        try {
            // dish = ServingBuffer.getNextToServe();
        } catch (Exception e) {
            throw e;
        }
    }

    public int getTableNumber() {
       // return dish.getTableNum();
    }

    public String getDishName() {
        //return dish.getDishName();
    }

    public void completeDish() {
        //dish.getDish();
    }

}
