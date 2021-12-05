package presenter.review_system;

import org.junit.Before;
import org.junit.Test;
import use_case.review.ReviewList;

import static org.junit.Assert.assertEquals;

/**
 * Test the AddReviewPresenter class.
 */
public class AddReviewPresenterTest {

    private AddReviewPresenter add;
    private ReviewList reviewList;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        add = new AddReviewPresenter();
        reviewList = new ReviewList();
    }

    /**
     * Test the addToReviewList method
     */
    @Test
    public void addToReviewList(){
        reviewList.reset();
        add.addToReviewList("1", true, 3, "good");
        add.addToReviewList("2", true, 4, "good");
        assertEquals(reviewList.sizeofList(), 2);
    }

    /**
     * Test the addToReviewList method
     */
    @Test
    public void length(){
        reviewList.reset();
        assertEquals(0, add.length());
    }

}
