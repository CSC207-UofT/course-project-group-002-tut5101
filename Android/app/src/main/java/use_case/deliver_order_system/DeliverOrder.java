package use_case.deliver_order_system;

import entity.order_system.DeliveryOrder;
import use_case.user_list.UserList;
import entity.delivery_system.DeliveryStaff;
import entity.User;

public class DeliverOrder implements DeliveryInputBoundary {
    private StaffDeliveryOutputBoundary outputBoundary;

    /**
     * Mark the current order as delivered
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a delivery staff.
     */
    public void delivered(String id) throws Exception{
        User user = UserList.getUserByUserId(id);
        ((DeliveryStaff) user).completeOrderDelivery();
    }

    /**
     * Get the next order to be delivered
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a delivery staff.
     */
    public void getToBeDeliver(String id) throws Exception{
        DeliveryStaff staff = (DeliveryStaff) UserList.getUserByUserId(id);
        if (!staff.hasCurrentOrder()) {
            staff.setCurrentOrder((DeliveryOrder) DeliveryBuffer.getDeliveryOrder());
        } else {
            throw new Exception("Already has one order in hands");
        }
    }

    /**
     * Set output adapter for delivery Staff
     * @param boundary The output adapter that processes the outputs.
     */
    public void setOutputBoundary(StaffDeliveryOutputBoundary boundary) {outputBoundary = boundary;}

    /**
     * Get description of the current order
     * @param id The id of the user
     */
    public void getItemInfo(String id) {
        DeliveryStaff staff = (DeliveryStaff) UserList.getUserByUserId(id);
        String orderInfo = staff.displayOrder();
        String destination = staff.getOrderDestination();

        if (orderInfo.equals("")){
            outputBoundary.setCurrentItemInfo("", "No current order to be displayed");
        }
        outputBoundary.setCurrentItemInfo(destination, orderInfo);
    }
}