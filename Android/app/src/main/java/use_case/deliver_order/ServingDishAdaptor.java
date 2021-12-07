package use_case.deliver_order;

import use_case.deliver_order.boundaries.DeliveryInputBoundary;
import use_case.deliver_order.boundaries.StaffDeliveryOutputBoundary;

public class ServingDishAdaptor implements DeliveryInputBoundary {
    private StaffDeliveryOutputBoundary outputBoundary;
    private final ServeDish sd = new ServeDish();

    /**
     * Mark current item as delivered
     *
     * @param id ID of the staff that is delivering the item
     * @throws Exception Throws exception as it is handled in presenter
     */
    public void delivered(String id) throws Exception {
        this.sd.delivered(id);
    }

    /**
     * Wrapper for get to be delivered item
     *
     * @param id ID of the staff
     * @throws Exception When there is no staff with the id, passes the exception to presenter
     */
    public void getToBeDeliver(String id) throws Exception {
        this.sd.getToBeDeliver(id);
    }

    /**
     * Set the output adapter for serving staff
     *
     * @param boundary The output adapter
     */
    public void setOutputBoundary(StaffDeliveryOutputBoundary boundary) {
        outputBoundary = boundary;
    }

    /**
     * @param id The id of the serving staff that has logged in.
     *           corresponding to the given id.
     */
    public void getItemInfo(String id) {
        String dishInfo = this.sd.getItemInfo(id);
        if (dishInfo.equals("")) {
            outputBoundary.setCurrentItemInfo("", "No current dish to be displayed");
        }
        outputBoundary.setCurrentItemInfo("", dishInfo);
    }
}
