package use_case.deliver_order;

import use_case.userlist.UserList;
import entity.delivery.ServingStaff;
import entity.User;

public class ServeDish implements DeliveryInputBoundary {
    private StaffDeliveryOutputBoundary outputBoundary;

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
     * Set the output adapter for serving staff
     * @param boundary The output adapter
     */
    public void setOutputBoundary(StaffDeliveryOutputBoundary boundary) {outputBoundary = boundary;}

    /**
     * @param id The id of the serving staff that has logged in.
     * corresponding to the given id.
     */
    public void getItemInfo(String id){
        User user = UserList.getUserByUserId(id);
        String dishInfo = ((ServingStaff) user).displayDish();

        if (dishInfo.equals("")){
            outputBoundary.setCurrentItemInfo("", "No current dish to be displayed");
        }
        outputBoundary.setCurrentItemInfo("", dishInfo);
    }
}