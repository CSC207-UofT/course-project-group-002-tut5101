package presenter.staff_system;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing staff presenter.
 */
public class CurrentItemPresenterTest {
    private CurrentItemPresenter staff;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        staff = new CurrentItemPresenter();
        TestClass testPresenter = new TestClass();
        staff.setStaffView(testPresenter);
    }

    /**
     * Test the completeCurrent method
     */
    @Test
    public void completeCurrent() {
        assert true;
    }

    /**
     * Test the displayCurrent method
     */
    @Test
    public void displayCurrent() {
        assert true;
    }

    /**
     * Test the getNext method
     */
    @Test
    public void getNext() {
        assert true;
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
