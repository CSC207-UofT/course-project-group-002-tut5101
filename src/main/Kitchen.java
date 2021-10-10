package main;

import java.util.ArrayDeque;
import java.util.Queue;

public class Kitchen {
    public static PlacedOrderQueue placeOrderQueue;
    public static Queue<Dish> ServingBuffer = new ArrayDeque<>();
    public static Queue<Order> DeliveryBuffer = new ArrayDeque<>();

    // TODO: handle exception
    public Dish getServingDish(){
        return ServingBuffer.remove();
    }

    // TODO: handle exception
    public Order getDeliveryOrder(){
        return DeliveryBuffer.remove();
    }




}
