package presenter.staff_system;

import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.order_list.DeliveryOrder;
import entity.order_list.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.deliver_order.DeliveryBuffer;
import use_case.deliver_order.DeliveryInputBoundary;
import use_case.deliver_order.ServingBuffer;
import use_case.dish_list.DishList;
import use_case.user_list.UserList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Test the GetNextItemPresenter class
 */
public class GetNextItemPresenterTest {
    private GetNextItemPresenter staff;
    private UserList userList;
    private DeliveryOrder order;
    private final DishList menu = new DishList();
    private ServingStaff servingStaff;
    private DeliveryStaff deliveryStaff;

    Dish dish1;
    Dish dish2;


    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        staff = new GetNextItemPresenter();
        servingStaff = new ServingStaff("6", "Eve", "12345");
        deliveryStaff = new DeliveryStaff("7", "Bob", "12345");

        userList = new UserList();
        userList.addUser(servingStaff);
        userList.addUser(deliveryStaff);

        dish1 = new Dish("Small fries", 10.0, new HashMap<>(), 200);
        dish2 = new Dish("Median fries", 10.0, new HashMap<>(), 250);
        HashMap<String, List<Dish>> orderedDishes = new HashMap<>();
        orderedDishes.put("Small fries", Collections.singletonList(dish1));
        order = new DeliveryOrder("Testing123", orderedDishes);
        dish1.setTableNum(2);
        ServingBuffer.addDish(dish1);
    }

    /**
     * Test the getNext method
     */
    @Test
    public void testGetNext() {
        ServingBuffer.addDish(dish1);
        DeliveryBuffer.addDeliveryOrder(order);
        try{
            staff.getNext("6");
            staff.getNext("7");
            assert true;
        }
        catch (Exception ignored){
            assert false;
        }

        try{
            staff.getNext("6");
            staff.getNext("7");
            assert false;
        }
        catch (Exception ignored){
            assert true;
        }
    }



}
