package presenter.delivery_system;

import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.order.DeliveryOrder;
import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.delivery_system.view_interfaces.StaffViewInterface;
import use_case.deliver_order.ServingBuffer;
import use_case.user_list.UserList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Testing staff presenter.
 */
public class CurrentItemPresenterTest {
    private CurrentItemPresenter staff;
    private DeliveryOrder order;
    private ServingStaff servingStaff;
    private DeliveryStaff deliveryStaff;

    Dish dish1;


    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        staff = new CurrentItemPresenter();
        TestClass testPresenter = new TestClass();
        staff.setStaffView(testPresenter);
        servingStaff = new ServingStaff("6", "Eve", "12345");
        deliveryStaff = new DeliveryStaff("7", "Bob", "12345");

        UserList userList = new UserList();
        userList.addUser(servingStaff);
        userList.addUser(deliveryStaff);

        dish1 = new Dish("Small fries", 10.0, new HashMap<>(), 200);
        HashMap<String, List<Dish>> orderedDishes = new HashMap<>();
        orderedDishes.put("Small fries", Collections.singletonList(dish1));
        order = new DeliveryOrder("Testing123", orderedDishes);
        dish1.setTableNum(2);
        ServingBuffer.addDish(dish1);
    }

    /**
     * Test the completeCurrent method
     */
    @Test
    public void completeCurrent() {
        servingStaff.setCurrentDish(dish1);
        deliveryStaff.setCurrentOrder(order);
        try{
            staff.completeCurrent("6");
            staff.completeCurrent("7");
            assert true;
        }
        catch (Exception ignored) {
            assert false;
        }
    }

    /**
     * Test the displayCurrent method
     */
    @Test
    public void displayCurrent() {
        servingStaff.setCurrentDish(dish1);
        deliveryStaff.setCurrentOrder(order);
        try {
            staff.displayCurrent("6");
            staff.displayCurrent("7");
            assert true;
        }
        catch (Exception ignored) {
            assert false;
        }
        try{
            staff.displayCurrent("1");
            assert false;
        }
        catch (Exception ignored) {
            assert true;
        }
    }

    /**
     * Test the getNext method
     */
    @Test
    public void setCurrentItemInfo(){
        staff.setCurrentItemInfo("Toronto","school");
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements StaffViewInterface {

        /**
         *
         * @param info information.
         */
        @Override
        public void displayCurrentItem(String info) {
            assert true;
        }
    }
}
