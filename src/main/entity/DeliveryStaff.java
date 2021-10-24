package entity;

import use_case.Kitchen;

/**
 * Class for delivery staff
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */

public class DeliveryStaff extends Staff {

    private Order currentOrder;

    /**
     * Construct an instance of s delivery staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     * @param staffSalary The salary of the staff
     */
    public DeliveryStaff(String staffNumber, String staffName, String password, int staffSalary) {
        super(staffNumber, staffName, password, staffSalary);
    }

    public void setCurrentOrder(Order order) {
        this.currentOrder = order;
    }

//    public void completeOrderDelivery() throws Exception{
//        if (currentOrder != null) {
//            this.currentOrder.setOrderStatus(ItemStatus.ORDER_COMPLETE);
//            currentOrder = null;
//        } else {
//            throw new Exception("No order to be delivered");
//        }
//    }
}


