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
        this.currentOrder = null;
    }

    /**
     * Let a delivery staff to get a dish to be delivered and deliver it to the destination
     * @return Return true on successful delivery, false otherwise
     */

        //TODO: REMOVE LATER? MOVE TO DeliverOrder?
   /** public boolean deliverOrder() {
        try {
            Order orderToBeDelivered = Kitchen.getDeliveryOrder();
            orderToBeDelivered.setOrderStatus(Order.Status.DELIVERED);
            //TODO: Combine with the functionality of map to get distance
        } catch (Exception e) {
            System.out.println("No order to be delivered, delivery list empty." + e.getMessage());
            return false;
        }
        return true;
    }
    **/


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


