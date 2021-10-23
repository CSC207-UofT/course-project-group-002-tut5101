package use_case;

import entity.DeliveryStaff;
import entity.User;

public class DeliverOrder {
    public void Served(String id) throws Exception{
        User user = UserList.getUser(id);

        if (user instanceof DeliveryStaff){
            //TODO: Finish this part in DeliveryStaff
           //  ((DeliveryStaff) user).completeServingDish();
        } else {
            throw new Exception("Not a delivery staff");
        }
    }

    public void getToServe(String id) throws Exception{
        User user = UserList.getUser(id);

        if (user instanceof DeliveryStaff){
            //TODO: Finish this part in DeliveryStaff
           // ((DeliveryStaff) user).setCurrentDish(Kitchen.getServingDish());
        } else {
            throw new Exception("Not a delivery staff");
        }
    }

}
