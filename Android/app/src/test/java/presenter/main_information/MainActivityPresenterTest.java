package presenter.main_information;


import org.junit.Before;
import org.junit.Test;
import use_case.dish_list.DishList;
import use_case.inventory.InventoryList;
import use_case.review.ReviewList;
import use_case.user_list.UserList;

import static junit.framework.TestCase.assertNotNull;

/**
 * Main activity presenter test
 */
public class MainActivityPresenterTest {
    ReviewList rl;
    UserList ul;
    DishList dl;
    InventoryList il;
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
        rl = new ReviewList();
        ul = new UserList();
        dl = new DishList();
        il = new InventoryList();
        assertNotNull(rl);
        assertNotNull(ul);
        assertNotNull(dl);
        assertNotNull(il);
    }

    /**
     * Test setContext method
     */
    @Test
    public void testSetContext(){
        presenter.setContext(null);
    }

}