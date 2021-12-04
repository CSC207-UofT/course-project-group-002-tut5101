package use_case.deliver_order;

public class ServingDishAdaptor implements DeliveryInputBoundary{
    private StaffDeliveryOutputBoundary outputBoundary;
    private final ServeDishInterface sd = new ServeDish();

    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a serving staff.
     */
    public void delivered(String id) throws Exception{
        this.sd.delivered(id);
    }

    /**
     * @param id The id of the serving staff that has logged in.
     * @throws Exception if the given id does not correspond to a serving staff.
     */

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
        String dishInfo = this.sd.getItemInfo(id);
        if (dishInfo.equals("")){
            outputBoundary.setCurrentItemInfo("", "No current dish to be displayed");
        }
        outputBoundary.setCurrentItemInfo("", dishInfo);
    }
}
