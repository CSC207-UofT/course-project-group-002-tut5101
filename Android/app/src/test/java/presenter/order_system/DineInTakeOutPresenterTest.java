package presenter.order_system;

import constant.order_system.OrderType;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the DineInTakeOutPresenter class
 */
public class DineInTakeOutPresenterTest {
    private DineInTakeOutPresenter dine;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        dine = new DineInTakeOutPresenter();
        TestClass testPresenter = new TestClass();
        dine.setSelectDineInTakeOutViewInterface(testPresenter);
    }

    /**
     * Test the retrieveOrderType method
     */
    @Test
    public void testRetrieveOrderType() {
        dine.retrieveOrderType("DINE_IN");
        dine.retrieveOrderType("DELIVERY");
    }

    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements SelectDineInTakeOutViewInterface{

        /**
         * Test if this method is run
         * @param orderType type of order
         */
        @Override
        public void updateOrderType(OrderType orderType) {
            assert true;
        }
    }
}
