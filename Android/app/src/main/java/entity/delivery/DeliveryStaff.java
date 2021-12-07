package entity.delivery;

import constant.order_system.ItemStatus;
import entity.order.DeliveryOrder;

/**
 * Class for delivery staff
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

@SuppressWarnings("SpellCheckingInspection")
public class DeliveryStaff extends Staff {

    private DeliveryOrder currentOrder;

    /**
     * Construct an instance of s delivery staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     */
    public DeliveryStaff(String staffNumber, String staffName, String password) {
        super(staffNumber, staffName, password);
    }

    /**
     * Set the current order of the delivery staff
     * @param order the current order of this delivery staff
     */
    public void setCurrentOrder(DeliveryOrder order) {
        this.currentOrder = order;
    }

    /**
     * Check if the staff has an order already
     * @return true when there is no current dish, false when there is one
     */
    public boolean hasCurrentOrder() {return currentOrder != null;}

    /**
     * Complete the current delivery order
     * @throws Exception if there is no order to be delivered
     */
    public void completeOrderDelivery() throws Exception{
        if (currentOrder != null) {
            this.currentOrder.setOrderStatus(ItemStatus.ORDER_COMPLETED);
            currentOrder = null;
        } else {
            throw new Exception("No order to be delivered");
        }
    }

    /**
     * display the current order
     * @return string representation of current order
     */
    public String displayOrder(){
        if (currentOrder != null){
            return currentOrder.getOrderContent();
        }
        return "";
    }

    public String getOrderDestination() {
        if (currentOrder != null){
            return currentOrder.getAddress();
        }
        return "";
    }
}
