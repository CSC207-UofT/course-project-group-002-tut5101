/**
 * Class for delivery staff
 * By Dedong Xie (1006702944)
 * 2021-10-10
 */
package main;

public class DeliveryStaff extends Staff{
    /**
     * Construct an instance of s delivery staff
     * @param staffName The name of the staff
     * @param staffNumber The number of the staff
     * @param staffSalary The salary of the staff
     */
    public DeliveryStaff(String staffName, int staffNumber, int staffSalary) {
        super(staffName, staffNumber, staffSalary);
    }

    /**
     * Let a delivery staff to get a dish to be delivered and deliver it to the destination
     */
    public void deliverOrder() {
        try {
            Order orderToBeDelivered = Kitchen.getDeliveryOrder();
            orderToBeDelivered.updateOrderStatus(Order.DELIVERED);
            //TODO: Combine with the functionality of map to get distance
        } catch (Exception e) {
            System.out.println("No order to be delivered, delivery list empty." + e.getMessage());
        }
    }

}
