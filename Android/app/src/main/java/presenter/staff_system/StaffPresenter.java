package presenter.staff_system;

import use_case.deliver_order.DeliveryInputBoundary;
import constant.manger_system.UserType;
import use_case.deliver_order.DeliverOrder;
import use_case.deliver_order.ServeDish;
import use_case.deliver_order.StaffDeliveryOutputBoundary;
import use_case.userlist.UserList;

/**
 * Controller class for staff.
 */


public class StaffPresenter implements StaffDeliveryOutputBoundary {
    private final DeliveryInputBoundary servingStaff = new ServeDish();
    private final DeliveryInputBoundary deliveryStaff = new DeliverOrder();
    private presenter.staff_system.StaffViewInterface staffView;

    public StaffPresenter() {
        servingStaff.setOutputBoundary(this);
        deliveryStaff.setOutputBoundary(this);
    }

    /**
     * Get the next item to be delivered by the staff with the id
     * @param id The id of the staff to get the next item of their responsibility
     *           (either dish for serving staff or order for delivery staff)
     * @throws Exception Throws Exception from getToBeDeliver and "id not staff" exception.
     */
    public void getNext(String id) throws Exception {
        DeliveryInputBoundary staff;
        staff = selectStaffTypeById(id);
        staff.getToBeDeliver(id);
    }

    /**
     * Display the current item to be delivered,
     * either a dish for serving staff or order for delivery staff.
     * @param id The id of the staff whose current item be viewed.
     * @throws Exception Throws Exception from staff.display() and "id not staff" exception.
     */
    public void displayCurrent(String id) throws Exception {
        DeliveryInputBoundary staff;
        staff = selectStaffTypeById(id);
        staff.getItemInfo(id);
    }

    /**
     * Set the current item of the staff to completed status.
     * @param id The id of the staff.
     * @throws Exception Throws Exception from staff.delivered() and "id not staff" exception.
     */
    public void completeCurrent(String id) throws Exception {
        DeliveryInputBoundary staff;
        staff = selectStaffTypeById(id);
        staff.delivered(id);
    }

    /**
     * Set the staff to be the correct instance type, either servingStaff or deliveryStaff
     * @param id The id of the current staff.
     * @return Reference to the instance in the object of the corresponding type of the current staff.
     * @throws Exception Throws "id not staff" exception when the id does not correspond to a staff
     * (servingStaff or deliveryStaff)
     */
    private DeliveryInputBoundary selectStaffTypeById(String id) throws Exception {
        UserType staffType = UserList.getUserTypeById(id);
        DeliveryInputBoundary staff;
        if (staffType == UserType.SERVING_STAFF) {
            staff = servingStaff;
        } else if (staffType == UserType.DELIVERY_STAFF) {
            staff = deliveryStaff;
        } else {
            throw new Exception("wrong id for staff");
        }
        return staff;
    }

    /**
     * Set the view targeted by the presenter
     * @param view The view to be updated by the presenter
     */
    public void setStaffView(presenter.staff_system.StaffViewInterface view) {staffView = view;}

    /**
     * Set the current item's info to view to present to user
     * @param destination Destination of the item(order or dish)
     * @param info Content of the item(dish names)
     */
    @Override
    public void setCurrentItemInfo(String destination, String info) {
        if (staffView instanceof GeoDestination) {
            ((GeoDestination) staffView).setItemDestination(destination);
        }
        staffView.displayCurrentItem(info);
    }
}
