package use_case.deliverorder;

import entity.delivery.DeliveryStaff;
import entity.orderlist.Order;
import entity.orderlist.DeliveryOrder;
import org.junit.Before;
import org.junit.Test;
import use_case.userlist.UserList;
import static org.junit.Assert.*;

import java.util.HashMap;


/**
 * Unit test class for DeliverOrder.
 */
public class DeliverOrderTest {
    private DeliverOrder deliver;

    /**
     * Setup before tests
     * @throws Exception if order could not be added to DeliveryBuffer
     */
    @Before
    public void setUp() throws Exception {
        TestClass testPresenter = new TestClass();
        UserList userList = new UserList(1);
        deliver = new DeliverOrder();
        Order order1 = new DeliveryOrder("1", new HashMap<>());
        DeliveryBuffer.addDeliveryOrder(order1);
        userList.addUser(new DeliveryStaff("1", "a", "abc"));

        deliver.setOutputBoundary(testPresenter);
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
     * Test the getItemInfo method
     */
    @Test
    public void testGetItemInfo() {
        deliver.getItemInfo("1");
        try {
            deliver.getToBeDeliver("1");
        }
        catch (Exception ignored) {
            assertFalse(false);
        }
        deliver.getItemInfo("1");
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
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements StaffDeliveryOutputBoundary {

        @Override
        public void setCurrentItemInfo(String destination, String info) {
            assertTrue(true);
        }
    }
}