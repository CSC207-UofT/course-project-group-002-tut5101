package use_case;

import entity.DeliveryStaff;
import entity.User;

public class DeliverOrder {
    public void Served(String id) throws Exception{
        User user = UserList.getUser(id);

        if (user instanceof DeliveryStaff){
           ((DeliveryStaff) user).completeOrderDelivery();
        } else {
            throw new Exception("Not a delivery staff");
        }
    }

    public void getToServe(String id) throws Exception{
        User user = UserList.getUser(id);

        if (user instanceof DeliveryStaff){
           ((DeliveryStaff) user).setCurrentOrder(Kitchen.getDeliveryOrder());
        } else {
            throw new Exception("Not a delivery staff");
        }
    }

}
