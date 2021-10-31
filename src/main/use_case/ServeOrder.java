package use_case;

import entity.ServingStaff;
import entity.User;

public class ServeOrder {

    public void completedCurrentDish(String id) throws Exception{
        User user = UserList.getUserByUserId(id);

        if (user instanceof ServingStaff){
           ((ServingStaff) user).completeServingDish();
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

    public String displayDish(String id) throws Exception{
        User user = UserList.getUserByUserId(id);

        if (user instanceof ServingStaff){
            String dishInfo = ((ServingStaff) user).displayDish();

            if (dishInfo.equals("")){
                return "No current dish to be displayed";
            }

            return dishInfo;
        } else {
            throw new Exception("Not a serving staff");
        }
    }


}
