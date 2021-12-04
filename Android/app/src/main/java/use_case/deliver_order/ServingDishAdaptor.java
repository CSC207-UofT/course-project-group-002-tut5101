package use_case.deliver_order;

import entity.User;
import entity.delivery.ServingStaff;
import use_case.userlist.UserList;

public class ServingDishAdaptor implements DeliveryInputBoundary{
    private StaffDeliveryOutputBoundary outputBoundary;
    private final ServeDish sd = new ServeDish();

    public void delivered(String id) throws Exception{
        this.sd.delivered(id);
    }

    public void getToBeDeliver(String id) throws Exception{
        this.sd.getToBeDeliver(id);
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
