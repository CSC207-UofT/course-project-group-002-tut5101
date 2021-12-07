package presenter.delivery_system;

import constant.manager_system.UserType;
import use_case.deliver_order.DeliverOrder;
import use_case.deliver_order.boundaries.DeliveryInputBoundary;
import use_case.deliver_order.ServingDishAdaptor;
import use_case.user_list.UserList;

/**
 * Presenter class for getting items.
 */
public class GetNextItemPresenter {
    private final DeliveryInputBoundary servingStaff = new ServingDishAdaptor();
    private final DeliveryInputBoundary deliveryStaff = new DeliverOrder();

    /**
     * Get the next item to be delivered by the staff with the id
     * @param id The id of the staff to get the next item of their responsibility
     *           (either dish for serving staff or order for delivery staff)
     * @throws Exception Throws Exception from getToBeDeliver and "id not staff" exception.
     */
    public void getNext(String id) throws Exception {
        DeliveryInputBoundary staff;
        staff = findStaffTypeById(id);
        staff.getToBeDeliver(id);
    }

    /**
     * Set the staff to be the correct instance type, either servingStaff or deliveryStaff
     * @param id The id of the current staff.
     * @return Reference to the instance in the object of the corresponding type of the current staff.
     * @throws Exception Throws "staff with id not found" exception when the id does not correspond to a staff
     * (servingStaff or deliveryStaff)
     */
    private DeliveryInputBoundary findStaffTypeById(String id) throws Exception {
        UserType staffType = UserList.getUserTypeById(id);
        DeliveryInputBoundary targetStaff;
        if (staffType == UserType.DELIVERY_STAFF) {
            targetStaff = deliveryStaff;
        } else if (staffType == UserType.SERVING_STAFF) {
            targetStaff = servingStaff;
        } else {
            throw new Exception("staff with id not found");
        }
        return targetStaff;
    }
}
