package use_case.review;

import entity.review.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the DeleteReviewUseCase class
 */
public class DeleteReviewUseCaseTest {
    private ReviewList reviewList;
    private Review review1;
    private Review review2;
    private Review review3;
    private Review review4;
    private DeleteReviewUseCase deleteReviewUseCase;

    /**
     * Setup before tests
     */
    @Before
    public void setUp(){

        reviewList = new ReviewList();
        review1 = new Review("Amy", true, 5, "good food",
                "1");
        review2 = new Review("Bob", false, 2, "Nice staff",
                "2");
        review3 = new Review("Amy", true, 1, "good food",
                "3");
        review4 = new Review("Amy", true, 0, "good food",
                "4");
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        reviewList.addReview(review3);
        reviewList.addReview(review4);
        deleteReviewUseCase = new DeleteReviewUseCase(reviewList);
    }

    /**
     * Test deleteBelowThree method
     */
    @Test
    public void testDeleteBelowThree(){
        assertEquals(4, reviewList.sizeofList());
        deleteReviewUseCase.delete(3);
    }

}