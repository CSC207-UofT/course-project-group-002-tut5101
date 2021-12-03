package presenter;

import presenter.staffsystem.StaffPresenter;
import entity.delivery_system.DeliveryStaff;
import entity.delivery_system.ServingStaff;
import entity.order_system.Dish;
import entity.order_system.Order;
import entity.order_system.DeliveryOrder;
import org.junit.Before;
import org.junit.Test;
import use_case.deliver_order_system.DeliveryBuffer;
import use_case.deliver_order_system.ServingBuffer;
import use_case.user_list.UserList;

import java.util.HashMap;

public class StaffPresenterTest {
    StaffPresenter staff;
    UserList userList;

    @Before
    public void setUp() {
        staff = new StaffPresenter();
        ServingStaff a = new ServingStaff("1", "a", "b");
        DeliveryStaff b = new DeliveryStaff("2", "b", "0");
        userList.addUser(a);
        userList.addUser(b);
        Dish dish1 = new Dish("m", 10.0, new HashMap<>(), 0);
        dish1.setTableNum(10);
        Order order1 = new DeliveryOrder("123 King's Street, M5S 2Z1, Toronto, ON", new HashMap<>());
        ServingBuffer.addDish(dish1);
        DeliveryBuffer.addDeliveryOrder(order1);
    }

    @Test
    public void getNextServingStaff() {
        try {
            staff.getNext("1");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void getNextDeliveryStaff() {
        try {
            staff.getNext("2");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void displayCurrentServingStaff() {
        try {
            staff.getNext("1");
            staff.displayCurrent("1");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void displayCurrentDeliveryStaff() {
        try {
            staff.getNext("2");
            staff.displayCurrent("2");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void completeCurrentServingStaff() {
        try {
            staff.getNext("1");
            staff.completeCurrent("1");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void completeCurrentDeliveryStaff() {
        try {
            staff.getNext("2");
            staff.completeCurrent("2");
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }
}