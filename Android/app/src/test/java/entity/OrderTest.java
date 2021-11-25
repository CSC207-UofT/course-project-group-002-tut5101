package entity;

import constant.orderSystem.ItemStatus;
import entity.orderList.Dish;
import entity.orderList.Order;
import entity.orderList.DineInOrder;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class OrderTest {

    Order order;
    Dish quarterPoundWithCheese;
    Dish smallFries;
    Dish coke;

    @Before
    public void setUp() {

        boolean dineIn = true;
        String[] dishNames = new String[]{"Quarter pound with cheese", "Small fries", "Coke"};
        String location = "1";

        quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200);
        smallFries = new Dish("Small fries", 1.99, new HashMap<>(), 200);
        coke = new Dish("Coke", 10.0, new HashMap<>(), 180);

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", Arrays.asList(new Dish[]{quarterPoundWithCheese}));
        dishes.put("Small fries", Arrays.asList(new Dish[]{smallFries}));
        dishes.put("Coke", Arrays.asList(new Dish[]{coke}));
        order = new DineInOrder(Integer.valueOf(location), dishes);

        // testToString();

    }

    public void testToString(){
        System.out.println(order);
    }



    @Test(timeout = 50)
    public void testGetOrderDineInOrTakeOut(){
        assertEquals("Dine In", order.getOrderDineInOrTakeOut());
    }

    @Test(timeout = 50)
    public void testSetDishStatus(){
        try {
            assertEquals(quarterPoundWithCheese, order.setDishStatus("Quarter pound with cheese"));
            assertEquals(ItemStatus.DISH_COOKED, quarterPoundWithCheese.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertEquals(smallFries, order.setDishStatus("Small fries"));
            assertEquals(ItemStatus.DISH_COOKED, smallFries.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(timeout = 50)
    public void testSetAndGetOrderStatus(){
        order.setOrderStatus(ItemStatus.ORDER_DELIVERED);
        assertEquals(ItemStatus.ORDER_DELIVERED, order.getOrderStatus());
        order.setOrderStatus(ItemStatus.ORDER_PLACED);
        assertEquals(ItemStatus.ORDER_PLACED, order.getOrderStatus());
    }

    @Test(timeout = 50)
    public void testUpdateOrderStatus(){
        order.setOrderStatus(ItemStatus.ORDER_PLACED);

        //Update the status of last dish, which should call updateOrderStatus
        try {
            assertEquals(quarterPoundWithCheese, order.setDishStatus("Quarter pound with cheese"));
            assertEquals(ItemStatus.DISH_COOKED, quarterPoundWithCheese.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertEquals(smallFries, order.setDishStatus("Small fries"));
            assertEquals(ItemStatus.DISH_COOKED, smallFries.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(coke, order.setDishStatus("Coke"));
            assertEquals(ItemStatus.DISH_COOKED, coke.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(ItemStatus.ORDER_COOKED, order.getOrderStatus());

    }





}
