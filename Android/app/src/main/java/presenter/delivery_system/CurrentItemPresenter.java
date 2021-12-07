package presenter.delivery_system;

import presenter.delivery_system.view_interfaces.GeoDestination;
import presenter.delivery_system.view_interfaces.StaffViewInterface;
import use_case.deliver_order.*;
import constant.manager_system.UserType;
import use_case.deliver_order.boundaries.DeliveryInputBoundary;
import use_case.deliver_order.boundaries.StaffDeliveryOutputBoundary;
import use_case.user_list.UserList;

/**
 * Presenter to show current Staff's item
 */


public class CurrentItemPresenter implements StaffDeliveryOutputBoundary {
    private final DeliveryInputBoundary servingStaff = new ServingDishAdaptor();
    private final DeliveryInputBoundary deliveryStaff = new DeliverOrder();
    private StaffViewInterface staffView;
    /**
     * Constructor for this class.
     */
    public CurrentItemPresenter() {
        servingStaff.setOutputBoundary(this);
        deliveryStaff.setOutputBoundary(this);
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
    public void setStaffView(StaffViewInterface view) {staffView = view;}

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
