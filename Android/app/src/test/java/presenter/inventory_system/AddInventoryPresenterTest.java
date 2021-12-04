package presenter.inventory_system;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the AddInventoryPresenter.
 */
public class AddInventoryPresenterTest {
    private AddInventoryPresenter add;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        add = new AddInventoryPresenter();
        TestClass testPresenter = new TestClass();
        add.setAddInventoryViewInterface(testPresenter);
    }

    /**
     * Test the getUserTypeById method
     */
    @Test
    public void presentLoginResult(){
        add.addNewInventory("name", "2","3","4","5");
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements AddinventoryViewInterface  {

        /**
         * test use
         *
         * @param message messages.
         */
        @Override
        public void updateInventoryList(String message) {
            assert true;
        }
    }

}
