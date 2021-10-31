package use_case;

import boundary.Delivery;
import entity.DeliveryStaff;
import entity.ServingStaff;
import entity.User;

public class DeliverOrder implements Delivery {

    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a delivery staff.
     */
    public void delivered(String id) throws Exception{
        User user = UserList.getUserByUserId(id);
        // TODO: show the delivery route here?
        ((DeliveryStaff) user).completeOrderDelivery();
    }

    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a delivery staff.
     */
    public void getToBeDeliver(String id) throws Exception{
        User user = UserList.getUserByUserId(id);
        ((DeliveryStaff) user).setCurrentOrder(DeliveryBuffer.getDeliveryOrder());
    }

    public String display(String id) throws Exception {
        User user = UserList.getUserByUserId(id);
        String orderInfo = ((DeliveryStaff) user).displayOrder();

        if (orderInfo.equals("")){
            return "No current dish to be displayed";
        }

        return orderInfo;
    }

}
