package controller;

import use_case.DeliverOrder;
import use_case.ServeOrder;

public class ServingStaffController {
    ServeOrder servingStaff = new ServeOrder();
    DeliverOrder deliveryStaff = new DeliverOrder();

    public void getNext(String id) throws Exception {
        String staffType = getUserTypeById(id);
        if (staffType.equals("ServingStaff")) {
            servingStaff.getToBeDeliver(id);
        } else if (staffType.equals("DeliveryStaff")) {
            deliveryStaff.getToBeDeliver(id);
        } else {
            throw new Exception("wrong id for staff");
        }
    }

    public String displayCurrent(String id) throws Exception {
        String staffType = getUserTypeById(id);
        if (staffType.equals("ServingStaff")) {
            return servingStaff.display(id);
        } else if (staffType.equals("DeliveryStaff")) {
            return deliveryStaff.display(id);
        } else {
            throw new Exception("wrong id for staff");
        }
    }

    public void completeCurrent(String id) throws Exception {
        String staffType = getUserTypeById(id);
        if (staffType.equals("ServingStaff")) {
            servingStaff.delivered(id);
        } else if (staffType.equals("DeliveryStaff")) {
            deliveryStaff.delivered(id);
        } else {
            throw new Exception("wrong id for staff");
        }
    }

    private String getUserTypeById(String id) {
        if (id.equals("0")) {
            return "ServingStaff";
        } else if (id.equals("1")) {
            return "DeliveryStaff";
        } else {
            return "Other";
        }
    }
}
