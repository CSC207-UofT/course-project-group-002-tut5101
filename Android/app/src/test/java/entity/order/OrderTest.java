package entity.order;

import constant.order_system.ItemStatus;
import constant.order_system.OrderType;
import org.junit.Before;
import org.junit.Test;


import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Order class and its subclasses DineInOrder and DeliveryOrder
 */
public class OrderTest {

    private DineInOrder dineInOrder;
    private DeliveryOrder deliveryOrder;
    private Order sameDishOrder;
    private Dish quarterPoundWithCheese;
    private Dish smallFries;
    private Dish coke;

    /**
     * setup before tests
     */
    @Before
    public void setUp() {

        String location = "1";

        quarterPoundWithCheese = new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200);
        smallFries = new Dish("Small fries", 1.99, new HashMap<>(), 200);
        coke = new Dish("Coke", 10.0, new HashMap<>(), 180);

        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", Collections.singletonList(quarterPoundWithCheese));
        dishes.put("Small fries", Collections.singletonList(smallFries));
        dishes.put("Coke", Collections.singletonList(coke));
        dineInOrder = new DineInOrder(Integer.parseInt(location), dishes);

        deliveryOrder = new DeliveryOrder("testing123", dishes);

        HashMap<String, List<Dish>> dishes2 = new HashMap<>();
        dishes2.put("Small fries", Arrays.asList(smallFries, smallFries));
        sameDishOrder = new DineInOrder(Integer.parseInt(location), dishes2);
    }

    /**
     * test Order class for setting the status of a dish in the order
     */
    @Test(timeout = 50)
    public void testSetDishStatus(){

        // for dineInOrder
        try {
            assertEquals(quarterPoundWithCheese, dineInOrder.setDishStatus("Quarter pound with cheese"));
            assertEquals(ItemStatus.DISH_COOKED, quarterPoundWithCheese.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertEquals(smallFries, dineInOrder.setDishStatus("Small fries"));
            assertEquals(ItemStatus.DISH_COOKED, smallFries.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertNull(dineInOrder.setDishStatus("blah"));
        }
        catch (Exception ignored) {
        }

        setUp();

        // for deliveryOrder
        try {
            assertEquals(quarterPoundWithCheese, deliveryOrder.setDishStatus("Quarter pound with cheese"));
            assertEquals(ItemStatus.DISH_COOKED, quarterPoundWithCheese.getStatus());
        } catch (Exception ignored) {
        }

        try {
            assertEquals(smallFries, deliveryOrder.setDishStatus("Small fries"));
            assertEquals(ItemStatus.DISH_COOKED, smallFries.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            deliveryOrder.setDishStatus("Small fries");
            assertNull(deliveryOrder.setDishStatus("Small fries"));
        }
        catch (Exception ignored) {
        }

        setUp();
        try {
            assertEquals(smallFries, sameDishOrder.setDishStatus("Small fries"));
            assertNull(sameDishOrder.setDishStatus("Small fries"));
        }
        catch (Exception ignored) {
        }
        setUp();

    }

    /**
     * test Order class for updating the order status
     */
    @Test(timeout = 50)
    public void testUpdateOrderStatus(){
        dineInOrder.setOrderStatus(ItemStatus.ORDER_PLACED);
        deliveryOrder.setOrderStatus(ItemStatus.ORDER_PLACED);

        //Dine In order
        //Update the status of last dish, which should call updateOrderStatus
        try {
            assertEquals(quarterPoundWithCheese, dineInOrder.setDishStatus("Quarter pound with cheese"));
            assertEquals(ItemStatus.DISH_COOKED, quarterPoundWithCheese.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(smallFries, dineInOrder.setDishStatus("Small fries"));
            assertEquals(ItemStatus.DISH_COOKED, smallFries.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(coke, dineInOrder.setDishStatus("Coke"));
            assertEquals(ItemStatus.DISH_COOKED, coke.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(ItemStatus.ORDER_COOKED, dineInOrder.getOrderStatus());


        setUp();
        // Delivery

        try {
            assertEquals(quarterPoundWithCheese, deliveryOrder.setDishStatus("Quarter pound with cheese"));
            assertEquals(ItemStatus.DISH_COOKED, quarterPoundWithCheese.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(smallFries, deliveryOrder.setDishStatus("Small fries"));
            assertEquals(ItemStatus.DISH_COOKED, smallFries.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(coke, deliveryOrder.setDishStatus("Coke"));
            assertEquals(ItemStatus.DISH_COOKED, coke.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(ItemStatus.ORDER_COOKED, deliveryOrder.getOrderStatus());

        setUp();
    }

    /**
     * test Order class getting and setting order status
     */
    @Test(timeout = 50)
    public void testSetAndGetOrderStatus(){
        dineInOrder.setOrderStatus(ItemStatus.ORDER_DELIVERED);
        assertEquals(ItemStatus.ORDER_DELIVERED, dineInOrder.getOrderStatus());
        dineInOrder.setOrderStatus(ItemStatus.ORDER_PLACED);
        assertEquals(ItemStatus.ORDER_PLACED, dineInOrder.getOrderStatus());
        setUp();
    }

    /**
     * Test Order class getting price of order
     */
    @Test(timeout = 50)
    public void testGetOrderPrice(){
        double actual1 = dineInOrder.getOrderPrice();
        double actual2 = deliveryOrder.getOrderPrice();
        double expected = 21.99;

        assert(expected == actual1);
        assert(expected == actual2);

    }

    /**
     * test Order class getting dishes in the order
     */
    @Test(timeout = 50)
    public void testGetDishes() {
        List<Dish> expected1 = new ArrayList<>();
        expected1.add(smallFries);
        expected1.add(coke);
        expected1.add(quarterPoundWithCheese);

        List<Dish> actual1 = dineInOrder.getDishes();
        List<Dish> actual2 = deliveryOrder.getDishes();
        assertEquals(expected1, actual1);
        assertEquals(expected1, actual2);

        List<Dish> expected2 = new ArrayList<>();
        expected2.add(smallFries);
        expected2.add(smallFries);

        List<Dish> actual3 = sameDishOrder.getDishes();
        assertEquals(expected2, actual3);

    }

    /**
     * Test Order class getting dish names and quantity of dish in order
     */
    @Test(timeout = 50)
    public void testGetDishAndQuantity() {
        HashMap<String, Integer> expected1 = new HashMap<>();
        expected1.put("Small fries", 1);
        expected1.put("Coke", 1);
        expected1.put("Quarter pound with cheese", 1);

        HashMap<String, Integer> actual1 = dineInOrder.getDishAndQuantity();
        HashMap<String, Integer> actual2 = deliveryOrder.getDishAndQuantity();
        assertEquals(expected1, actual1);
        assertEquals(expected1, actual2);

        HashMap<String, Integer> expected2 = new HashMap<>();
        expected2.put("Small fries", 2);
        HashMap<String, Integer> actual3 = sameDishOrder.getDishAndQuantity();
        assertEquals(expected2, actual3);
    }

    /**
     * test getting the order content
     */
    @Test(timeout = 50)
    public void testGetOrderContent() {
        String actual1 = dineInOrder.getOrderContent();
        String actual2 = deliveryOrder.getOrderContent();

        String expected = "Order contents: \n" + "\tDish: " + "Small fries" +
                " Quantity: " + 1 + "\n" +
                "\tDish: " + "Coke" + " Quantity: " + 1 + "\n" +
                "\tDish: " + "Quarter pound with cheese" + " Quantity: " + 1 + "\n" +
                "====================";

        assertEquals(actual1, expected);
        assertEquals(actual2, expected);

        String actual3 = sameDishOrder.getOrderContent();
        String expected2 = "Order contents: \n" + "\tDish: " + "Small fries" +
                " Quantity: " + 2 + "\n" +"====================";
        assertEquals(actual3, expected2);

    }

    /**
     * test Order class toString method
     */
    @Test(timeout = 50)
    public void testToString(){
        String actual1 = dineInOrder.toString();
        String actual2 = deliveryOrder.toString();


        String orderString = "ORDER DETAILS" +
                "\n------------------------------\n";

        assert (actual1.contains(orderString));
        assert (actual2.contains(orderString));
        String dishInfo1 = "Dish Name: " + "Quarter pound with cheese" +
                "\n Quantity: " + 1 +
                "\n Ingredients: " + "{}" +
                "\n Price: $" + 10.0 +
                "\n------------------------------\n";
        assert (actual1.contains(dishInfo1));
        assert (actual2.contains(dishInfo1));


    }

    /**
     * test Order class equals method
     */
    @Test(timeout = 50)
    public void testEquals() {
        DineInOrder dineInOrder2;
        String location = "1";
        HashMap<String, List<Dish>> dishes = new HashMap<>();
        dishes.put("Quarter pound with cheese", Collections.singletonList(quarterPoundWithCheese));
        dishes.put("Small fries", Collections.singletonList(smallFries));
        dishes.put("Coke", Collections.singletonList(coke));
        dineInOrder2 = new DineInOrder(Integer.parseInt(location), dishes);
        assert(dineInOrder.equals(dineInOrder2));
    }

    /**
     * test Order class get order type
     */
    @Test(timeout = 50)
    public void testGetOrderType() {
        assertEquals(OrderType.DINE_IN, dineInOrder.getOrderType());
        assertEquals(OrderType.DELIVERY, deliveryOrder.getOrderType());
    }

    // For Dine In Orders only

    /**
     * Test getting table number for a DineInOrder
     */
    @Test(timeout = 50)
    public void testGetTableNum(){
        int expected = 1;
        int actual = dineInOrder.getTableNum();
        assertEquals(expected, actual);
    }

    // For Delivery Orders only

    /**
     * Test getting address for a DeliveryOrder
     */
    @Test(timeout = 50)
    public void testGetAddress() {
        String expected = "testing123";
        String actual = deliveryOrder.getAddress();
        assertEquals(expected, actual);
    }






}
