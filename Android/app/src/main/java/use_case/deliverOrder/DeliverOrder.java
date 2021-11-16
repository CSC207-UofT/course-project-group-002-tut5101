package use_case.deliverOrder;

import entity.User;
import entity.delivery.DeliveryStaff;
import use_case.boundary.Delivery;
import use_case.userList.UserList;

public class DeliverOrder implements Delivery {

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
            staff.setCurrentOrder(DeliveryBuffer.getDeliveryOrder());
        } else {
            throw new Exception("Already has one order in hands");
        }
    }

    /**
     * Get description of the current order
     * @param id The id of the user
     * @return String of description of the order
     * @throws Exception When there is no order, throws exception
     */
    public String display(String id) throws Exception {
        DeliveryStaff staff = (DeliveryStaff) UserList.getUserByUserId(id);
        String orderInfo = staff.displayOrder();

        if (orderInfo.equals("")){
            return "No current order to be displayed";
        }
        return orderInfo;
    }
}