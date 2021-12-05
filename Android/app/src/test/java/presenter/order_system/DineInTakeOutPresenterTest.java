package presenter.order_system;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import constant.file_system.FileName;
import constant.order_system.OrderType;
import org.junit.Before;
import org.junit.Test;
import use_case.dish_list.DishList;

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
     * Empty fake activity class implementing the output boundary
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
