package presenter.review_system;

import org.junit.Before;
import org.junit.Test;
import presenter.review_system.view_interface.DisplayReviewViewInterface;

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
        TestClass testPresenter = new TestClass();
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
     * Empty fake presenter class implementing the view interface
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
