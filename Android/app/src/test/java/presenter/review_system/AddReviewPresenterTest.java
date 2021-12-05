package presenter.review_system;

import com.example.androidgui.user_activities.AddReviewCommentActivity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the AddReviewPresenter class.
 */
public class AddReviewPresenterTest {

    private AddReviewPresenter add;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        add = new AddReviewPresenter(new AddReviewCommentActivity());
    }

    /**
     * Test the addToReviewList method
     */
    @Test
    public void addToReviewList(){
        add.addToReviewList("1", true, 10, "good", "nice");
    }

    /**
     * Test the addToReviewList method
     */
    @Test
    public void length(){
        assertEquals(add.length(),0);
    }

}
