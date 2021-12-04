package presenter.manager_system;


import org.junit.Before;


/**
 * Test the manager presenter.
 */
public class ManagerPresenterTest {

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        ManagerPresenter managerPresenter = new ManagerPresenter();
        TestClass testPresenter = new TestClass();
        managerPresenter.setViewInterface(testPresenter);
    }

    /**
     * Empty fake presenter class implementing the view interface
     */
    private static class TestClass implements EnrollStaffViewInterface{

        /**
         *
         * @param staffTypes array of available staff types
         */
        @Override
        public void setAvailStaffTypeOptions(String[] staffTypes) {

        }

        /**
         *
         * @param id id of the new staff
         */
        @Override
        public void setNewUserId(String id) {

        }
    }

}
