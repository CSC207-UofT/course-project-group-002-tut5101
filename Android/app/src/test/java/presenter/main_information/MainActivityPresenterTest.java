package presenter.main_information;


import org.junit.Before;
import org.junit.Test;

/**
 * Main activity presenter test
 */
public class MainActivityPresenterTest {
    private MainActivityPresenter presenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        presenter = new MainActivityPresenter();
    }


    /**
     * Test setData method
     */
    @Test
    public void testSetData() {
        presenter.setData();
        assert true;
    }

}