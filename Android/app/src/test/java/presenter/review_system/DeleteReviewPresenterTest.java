package presenter.review_system;

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
        reviewPresenter = new DeleteReviewPresenter();
    }

    /**
     * Test the getting dish list method
     */
    @Test
    public void decideReview(){
        reviewPresenter.decideReview("ONE");
    }
}
