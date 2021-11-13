package use_case;

import use_case.boundary.Delivery;
import entity.ServingStaff;
import entity.User;

public class ServeOrder implements Delivery {


    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a serving staff.
     */
    public void delivered(String id) throws Exception{
        User user = UserList.getUserByUserId(id);
        ((ServingStaff) user).completeServingDish();
    }

    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a serving staff.
     */
    public void getToBeDeliver(String id) throws Exception{
        ServingStaff staff = (ServingStaff) UserList.getUserByUserId(id);
        if (!staff.hasCurrentDish()) {
            staff.setCurrentDish(ServingBuffer.getNextToServe());
        } else {
            throw new Exception("Already has one dish in hands");
        }
    }

    /**
     * @param id The id of the serving staff that has logged in.
     * @return A string representation of the information in the current dish of the serving staff
     * corresponding to the given id.
     * @throws Exception if the given id does not correspond to a serving staff.
     */
    public String display(String id) throws Exception{
        User user = UserList.getUserByUserId(id);
        String dishInfo = ((ServingStaff) user).displayDish();

        if (dishInfo.equals("")){
            return "No current dish to be displayed";
        }
        return dishInfo;
    }
}