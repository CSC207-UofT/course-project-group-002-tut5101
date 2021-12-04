package use_case.review;

import entity.review.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the AffReviewUseCase class
 */
public class AddReviewUseCaseTest {
    private AddReviewUseCase add;

    /**
     * Setup before tests
     */
    @Before
    public void setUp(){
        ReviewList reviewList = new ReviewList();
        Review review1 = new Review("Amy", true, 5, "good food",
                "1");
        Review review2 = new Review("Bob", false, 2, "Nice staff",
                "2");
        Review review3 = new Review("Amy", true, 1, "good food",
                "3");
        Review review4 = new Review("Amy", true, 0, "good food",
                "4");
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        reviewList.addReview(review3);
        reviewList.addReview(review4);
        add = new AddReviewUseCase();
    }

    /**
     * Test addToReviewList method
     */
    @Test
    public void addToReviewList(){
        add.addToReviewList("amy", true, 1,"dog", "oops");
    }

    /**
     * Test length method
     */
    @Test
    public void length(){
        assertEquals(0, add.length());
    }

}
