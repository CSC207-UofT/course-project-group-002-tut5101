package use_case;

import entity.delivery.DeliveryStaff;
import entity.orderlist.Order;
import entity.orderlist.DeliveryOrder;
import org.junit.Before;
import org.junit.Test;
import use_case.deliverorder.DeliverOrder;
import use_case.deliverorder.DeliveryBuffer;
import use_case.userlist.UserList;

import java.util.HashMap;

/**
 * Unit test class for DeliverOrder.
 */
public class DeliverOrderTest {
    DeliverOrder deliver;
    UserList userList;
    @Before
    public void setUp() throws Exception {
        deliver = new DeliverOrder();
        Order order1 = new DeliveryOrder("1", new HashMap<>());
        DeliveryBuffer.addDeliveryOrder(order1);
        userList.addUser(new DeliveryStaff("1", "a", "abc"));
    }

    /**
     * Testing getToBeDeliver method.
     */
    @Test
    public void getToBeDeliver() {
        try {
            deliver.getToBeDeliver("1");
        } catch (Exception e) {
            assert false;
        }
    }

    /**
     *
     * Testing delivered method.
     */
    @Test
    public void delivered() {
        try {
            deliver.getToBeDeliver("1");
            deliver.delivered("1");
        } catch (Exception e) {
            assert false;
        }
    }
}