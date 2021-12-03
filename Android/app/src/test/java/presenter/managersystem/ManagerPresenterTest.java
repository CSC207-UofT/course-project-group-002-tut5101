package presenter.managersystem;


import org.junit.Before;


/**
 * Test the manager presenter.
 */
public class ManagerPresenterTest {
    private ManagerPresenter managerPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        managerPresenter = new ManagerPresenter();
        TestClass testPresenter = new TestClass();
        managerPresenter.setViewInterface(testPresenter);
    }

    /**
     * Empty fake presenter class implementing the output boundary
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
