package reviewsystem;

import org.junit.Before;
import org.junit.Test;
import presenter.reviewsystem.DisplayReviewViewInterface;
import presenter.reviewsystem.ReviewPresenter;

/**
 * Test the ReviewPresenterTest class.
 */
public class ReviewPresenterTest {

    private ReviewPresenter reviewPresenter;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        reviewPresenter = new ReviewPresenter();
        TestClass testPresenter = new ReviewPresenterTest.TestClass();
        reviewPresenter.setDisplayReviewViewInterface(testPresenter);
    }

    /**
     * Test the getting dish list method
     */
    @Test
    public void reviewsInListAsString(){
        reviewPresenter.reviewsInListAsString();
    }

    /**
     * Test the getting dish list method
     */
    @Test
    public void updateReviewDisplay(){
        reviewPresenter.updateReviewDisplay("review1");
    }

    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements DisplayReviewViewInterface {

        /**
         * for testing.
         *
         * @param toString to string of the review.
         */
        @Override
        public void setReviewsText(String toString) {
            assert true;
        }
    }

}
