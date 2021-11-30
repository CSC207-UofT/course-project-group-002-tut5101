package use_case;

import entity.delivery.DeliveryStaff;
import entity.orderList.Order;
import entity.orderList.DeliveryOrder;
import org.junit.Before;
import org.junit.Test;
import use_case.deliverOrder.DeliverOrder;
import use_case.deliverOrder.DeliveryBuffer;
import use_case.userList.UserList;

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
        userList.addUser(new DeliveryStaff("1", "a", "abc", 10));
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