import entities.Inventory;
import entities.InventoryList;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * The kitchen in the restaurant.
 *
 * This class serves as an intermediate step between the customers and the delivery / serving staff.
 * It gets new orders from the placeOrderQueue, and update the status of the dish, and depending
 * on the type of the order, add the dish / order to the queues for either delivery staff or
 * serving staff.
 *
 * Author: Raymond Liu, 2021/10/11
 */

public class Kitchen {

    /**
     * A static instance of the PlaceOrderQueue class. The Kitchen uses this instance to
     * access the next order to be cooked.
     */
    public static PlacedOrderQueue placeOrderQueue = new PlacedOrderQueue();

    /**
     * The buffer queue where each element is a "tuple" of table number and a dish; the serving
     * staff calls method to access the next dish to be served.
     */
    public static Queue<DishInfo> servingBuffer = new ArrayDeque<>();

    /**
     * The buffer queue of completed orders for delivery staff to access.
     */
    public static Queue<Order> deliveryBuffer = new ArrayDeque<>();

    /**
     * The current order that the Kitchen is working on.
     */
    private static Order currentOrder;


    /**
     * The getter method for ServingStaff to call to get the next dish to serve.
     * @return a DishInfo instance, which contains the table number of the dish and the dish itself.
     */
    public static DishInfo getServingDish(){
        return servingBuffer.poll();
    }


    /**
     * The getter method for DeliveryStaff to call to get the next order to delivery.
     * @return an Order instance to be delivered.
     */
    public static Order getDeliveryOrder(){
        return deliveryBuffer.poll();
    }


    /**
     * Get the next order to cook from the placeOrderQueue instance.
     */
    public static void getNextToCook(){
        currentOrder = placeOrderQueue.getNextOrder();
    }


    /**
     * This method should be called only when a dish is cooked.
     *
     * Update the inventory and status of the dish, then depending on the type of order that this
     * dish belongs to, either add the dish to the servingBuffer or add the complete order to
     * deliveryBuffer.
     *
     * The currentOrder will be updated if the current order is finished.
     * @param dish the dish that is cooked.
     */
    public static void cookedDish(Dish dish){
        updateInventory(dish);
        boolean orderCompleted = currentOrder.setDishStatusAndCheckOrderStatus(dish);

        if (currentOrder.getOrderDineInOrTakeOut().equals("Dine In")){
            servingBuffer.add(new DishInfo(currentOrder.getTableNum(), dish));

            if (orderCompleted){
                getNextToCook();
            }
        } else {
            if (orderCompleted) {
                deliveryBuffer.add(currentOrder);
                getNextToCook();
            }
        }
    }

    //TODO: consider splitting the update inventory method from cookedDish


    /**
     * Update the inventory using the quantity of each ingredient that this dish needs.
     * @param dish the dish that is cooked.
     */
    private static void updateInventory(Dish dish){
        HashMap<String, Double> ingredients = dish.getIngredients();
        for (String item: ingredients.keySet()){
            double newQuantity = InventoryList.getTotalQuantity(item) - ingredients.get(item);
            InventoryList.setQuantity(item, newQuantity);
        }
        // TODO: handle cases when the new quantity is negative.
    }
}


/**
 * A "tuple" that contains the information of a dine-in dish.
 * The first element is the table number of this dish, and the second element is the dish itself.
 */
class DishInfo{
    private int tableNum;
    private Dish dish;

    DishInfo(int tableNum, Dish dish){
        this.tableNum = tableNum;
        this.dish = dish;
    }

    int getTableNum(){
        return this.tableNum;
    }

    Dish getDish(){
        return this.dish;
    }
}
