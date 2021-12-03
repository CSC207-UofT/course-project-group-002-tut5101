package reviewsystem;

import org.junit.Before;
import org.junit.Test;
import presenter.reviewsystem.DeleteReviewPresenter;

/**
 * Test the DeleteReviewPresenterTest class.
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
