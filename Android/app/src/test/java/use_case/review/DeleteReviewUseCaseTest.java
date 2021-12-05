package use_case.review;

import com.example.androidgui.manager_activities.DeleteReviewActivity;
import constant.file_system.FileLocation;
import entity.review.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the DeleteReviewUseCase class
 */
public class DeleteReviewUseCaseTest {
    private ReviewList reviewList;
    private DeleteReviewUseCase deleteReviewUseCase;

    /**
     * Setup before tests
     */
    @Before
    public void setUp(){

        reviewList = new ReviewList(FileLocation.REVIEW_FILE);
        reviewList.setContext(new DeleteReviewActivity());
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
        deleteReviewUseCase = new DeleteReviewUseCase();
        deleteReviewUseCase.setContext(new DeleteReviewActivity());
    }

    /**
     * Test deleteBelowThree method
     */
    @Test
    public void testDelete(){
        assertEquals(0, reviewList.sizeofList());
        deleteReviewUseCase.delete(3);
    }

}