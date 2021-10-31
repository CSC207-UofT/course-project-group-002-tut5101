package controller;

import boundary.ServingOrderInterface;
import boundary.ServingStaffControllerInterface;
import use_case.ServeOrder;

public class ServingStaffController implements ServingStaffControllerInterface {
    ServeOrder servingStaff;

    public ServingStaffController(String id) {
        servingStaff = new ServeOrder(id);
    }
    public void getNextServeDish() throws Exception {
        servingStaff.getToServe();
    }

    public String displayDish() throws Exception {
        if (servingStaff instanceof ServingOrderInterface) {
            return servingStaff.displayDish();
        } else {
            throw new Exception("Not servingStaff");
        }
    }

    public void completeDish() throws Exception {
        if (servingStaff instanceof ServingOrderInterface) {
            servingStaff.completeCurrentDish();
        } else {
            throw new Exception("Not servingStaff");
        }
    }

}
