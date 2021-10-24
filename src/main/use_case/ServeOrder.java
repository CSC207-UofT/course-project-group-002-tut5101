package use_case;

import entity.ServingStaff;
import entity.User;

public class ServeOrder {

    public void Served(String id) throws Exception{
        User user = UserList.getUserByUserId(id);

        if (user instanceof ServingStaff){
           // ((ServingStaff) user).completeServingDish();
        } else {
            throw new Exception("Not a serving staff");
        }
    }

    public void getToServe(String id) throws Exception{
        User user = UserList.getUserByUserId(id);

        if (user instanceof ServingStaff){
            ((ServingStaff) user).setCurrentDish(ServingBuffer.getNextToServe());
        } else {
            throw new Exception("Not a serving staff");
        }
    }
}
