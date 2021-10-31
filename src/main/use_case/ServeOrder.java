package use_case;

import boundary.ServingOrderInterface;
import entity.ServingStaff;
import entity.User;

public class ServeOrder implements ServingOrderInterface {
    User user;

    public ServeOrder(String id) {
        user = UserList.getUserByUserId(id);
    }

    public void completeCurrentDish() throws Exception{
        if (user instanceof ServingStaff){
           ((ServingStaff) user).completeServingDish();
        } else {
            throw new Exception("Not a serving staff");
        }
    }

    public void getToServe() throws Exception{
        if (user instanceof ServingStaff){
            ((ServingStaff) user).setCurrentDish(ServingBuffer.getNextToServe());
        } else {
            throw new Exception("Not a serving staff");
        }
    }

    public String displayDish() throws Exception {
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
