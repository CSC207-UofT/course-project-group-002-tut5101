package use_case.deliverorder;

import entity.delivery.DeliveryStaff;
import entity.orderlist.Order;
import entity.orderlist.DeliveryOrder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
        userList = new UserList(1);
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
        try {
            deliver.getToBeDeliver("1");
        } catch (Exception e) {
            assert true;
        }
        try{
            deliver.delivered("1");
        }
        catch (Exception e) {
            assert false;
        }
        try {
            deliver.getToBeDeliver("1");
        } catch (Exception e) {
            assert true;
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

    /**
     * Testing display method
     */
    @Test
    public void testDisplay() {
        String expectedNone = "No current order to be displayed";
        String actualNone = deliver.display("1");
        try {
            deliver.getToBeDeliver("1");
        }
        catch (Exception e) {
            assert false;
        }
        String content = "Order contents: \n" +
                "====================";
        String expected = "Address: " + "1" + "\n" + content;
        String actual = deliver.display("1");
        assertEquals(expectedNone, actualNone);
        assertEquals(expected, actual);
    }
}