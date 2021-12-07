package use_case.deliver_order;

import entity.delivery.ServingStaff;
import entity.user.User;
import use_case.user_list.UserList;

public class ServeDish {

    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a serving staff.
     */
    public void delivered(String id) throws Exception {
        User user = UserList.getUserByUserId(id);
        ((ServingStaff) user).completeServingDish();
    }

    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a serving staff.
     */
    public void getToBeDeliver(String id) throws Exception {
        ServingStaff staff = (ServingStaff) UserList.getUserByUserId(id);
        if (!staff.hasCurrentDish()) {
            staff.setCurrentDish(ServingBuffer.getNextToServe());
        } else {
            throw new Exception("Already has one dish in hands");
        }
    }

    /**
     * @param id The id of the serving staff that has logged in.
     *           corresponding to the given id.
     */
    public String getItemInfo(String id) {
        User user = UserList.getUserByUserId(id);
        return ((ServingStaff) user).displayDish();
    }
}