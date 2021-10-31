package controller;

import boundary.Delivery;
import constant.UserType;
import use_case.DeliverOrder;
import use_case.ServeOrder;
import use_case.UserList;

public class StaffController {
    ServeOrder servingStaff = new ServeOrder();
    DeliverOrder deliveryStaff = new DeliverOrder();

    public void getNext(String id) throws Exception {
        Delivery staff;
        try {
            staff = selectStaffTypeById(id);
            staff.getToBeDeliver(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public String displayCurrent(String id) throws Exception {
        Delivery staff;
        try {
            staff = selectStaffTypeById(id);
            return staff.display(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void completeCurrent(String id) throws Exception {
        Delivery staff;
        try {
            staff = selectStaffTypeById(id);
            staff.delivered(id);
        } catch (Exception e) {
            throw e;
        }
    }

    private Delivery selectStaffTypeById(String id) throws Exception {
        UserType staffType = UserList.getUserTypeById(id);
        Delivery staff;
        if (staffType == UserType.SERVING_STAFF) {
            staff = servingStaff;
        } else if (staffType == UserType.DELIVERY_STAFF) {
            staff = deliveryStaff;
        } else {
            throw new Exception("wrong id for staff");
        }
        return staff;
    }
}
