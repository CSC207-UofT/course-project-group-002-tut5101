package controller.staffSystem;

import constant.mangerSystem.UserType;
import use_case.boundary.Delivery;
import use_case.deliverOrder.DeliverOrder;
import use_case.serveDish.ServeOrder;
import use_case.userList.UserList;

/**
 * Controller class for staff.
 */


public class StaffController {
    ServeOrder servingStaff = new ServeOrder();
    DeliverOrder deliveryStaff = new DeliverOrder();

    /**
     * Get the next item to be delivered by the staff with the id
     * @param id The id of the staff to get the next item of their responsibility
     *           (either dish for serving staff or order for delivery staff)
     * @throws Exception Throws Exception from getToBeDeliver and "id not staff" exception.
     */
    public void getNext(String id) throws Exception {
        Delivery staff;
        try {
            staff = selectStaffTypeById(id);
            staff.getToBeDeliver(id);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Display the current item to be delivered,
     * either a dish for serving staff or order for delivery staff.
     * @param id The id of the staff whose current item be viewed.
     * @return String with the infomation of the item to be delivered.
     * @throws Exception Throws Exception from staff.display() and "id not staff" exception.
     */
    public String displayCurrent(String id) throws Exception {
        Delivery staff;
        try {
            staff = selectStaffTypeById(id);
            return staff.display(id);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Set the current item of the staff to completed status.
     * @param id The id of the staff.
     * @throws Exception Throws Exception from staff.delivered() and "id not staff" exception.
     */
    public void completeCurrent(String id) throws Exception {
        Delivery staff;
        try {
            staff = selectStaffTypeById(id);
            staff.delivered(id);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Set the staff to be the correct instance type, either servingStaff or deliveryStaff
     * @param id The id of the current staff.
     * @return Reference to the instance in the object of the corresponding type of the current staff.
     * @throws Exception Throws "id not staff" exception when the id does not correspond to a staff
     * (servingStaff or deliveryStaff)
     */
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
