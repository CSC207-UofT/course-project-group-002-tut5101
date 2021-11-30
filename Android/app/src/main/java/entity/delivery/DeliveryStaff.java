package entity.delivery;

import constant.ordersystem.ItemStatus;
import entity.orderlist.DeliveryOrder;

/**
 * Class for delivery staff
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class DeliveryStaff extends Staff {

    private DeliveryOrder currentOrder;

    /**
     * Construct an instance of s delivery staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     * @param staffSalary The salary of the staff
     */
    public DeliveryStaff(String staffNumber, String staffName, String password, int staffSalary) {
        super(staffNumber, staffName, password, staffSalary);
    }

    public void setCurrentOrder(DeliveryOrder order) {
        this.currentOrder = order;
    }

    /**
     * Check if the staff has an order already
     * @return true when there is no current dish, false when there is one
     */
    public boolean hasCurrentOrder() {return currentOrder != null;}

    public void completeOrderDelivery() throws Exception{
        if (currentOrder != null) {
            this.currentOrder.setOrderStatus(ItemStatus.ORDER_COMPLETED);
            currentOrder = null;
        } else {
            throw new Exception("No order to be delivered");
        }
    }

    public String displayOrder(){
        if (currentOrder != null){
            return "Address: " + currentOrder.getAddress() + "\n" + currentOrder.getOrderContent();
        }
        return "";
    }
}
