package presenter.review_system;

import com.example.androidgui.manager_activities.DeleteReviewActivity;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the DeleteReviewPresenter class.
 */
public class DeleteReviewPresenterTest {

    private DeleteReviewPresenter reviewPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        reviewPresenter = new DeleteReviewPresenter(new DeleteReviewActivity());
    }

    /**
     * Test the getting dish list method
     */
    @Test
    public void decideReview(){
        reviewPresenter.decideReview("ONE");
    }
}
