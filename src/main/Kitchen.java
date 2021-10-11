package main;

import java.util.ArrayDeque;
import java.util.Queue;

public class Kitchen {
    public static PlacedOrderQueue placeOrderQueue;

    // TODO: change each element of servingBuffer to tuple of table num and Dish.
    public static Queue<Dish> servingBuffer = new ArrayDeque<>();
    public static Queue<Order> deliveryBuffer = new ArrayDeque<>();
    private static Order currentOrder = null;

    // TODO: handle exception
    public static Dish getServingDish(){
        return servingBuffer.remove();
    }

    // TODO: handle exception
    public static Order getDeliveryOrder(){
        return deliveryBuffer.remove();
    }

    private static void getNextToCook(){
        currentOrder = placeOrderQueue.getNextOrder();
    }

    private static void updateDishStatus(Dish dish){
        // TODO: throw exceptions if currentOrder is null?
        currentOrder.updateDishStatus(dish);

        if (currentOrder.getOrderDineInOrTakeOut().equals("Dine In")){
            servingBuffer.add(dish);
        } else {
            if (currentOrder.getOrderStatus().equals("Order Cooked")) {
                deliveryBuffer.add(currentOrder);
                getNextToCook();
            }
        }
    }

    private static void updateInventory(Dish dish){
        // TODO: to be implemented.
    }




}
