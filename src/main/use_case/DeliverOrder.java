package use_case;

import entity.DeliveryStaff;
import entity.User;

public class DeliverOrder {
    public void Delivered(String id) throws Exception{
        User user = UserList.getUserByUserId(id);

        if (user instanceof DeliveryStaff){
            // TODO: show the delivery route here?
           // ((DeliveryStaff) user).completeOrderDelivery();
        } else {
            throw new Exception("Not a delivery staff");
        }
    }

    public void getOrderToBeDelivered(String id) throws Exception{
        User user = UserList.getUserByUserId(id);

        if (user instanceof DeliveryStaff){
           ((DeliveryStaff) user).setCurrentOrder(DeliveryBuffer.getDeliveryOrder());
        } else {
            throw new Exception("Not a delivery staff");
        }
    }

}
