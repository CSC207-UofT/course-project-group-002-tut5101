package use_case.review;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.example.androidgui.manager_activities.DeleteReviewActivity;
import entity.review.Review;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

/**
 * Test the DeleteReviewUseCase class
 */
public class DeleteReviewUseCaseTest {
    private ReviewList reviewList;
    private DeleteReviewUseCase deleteReviewUseCase;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    /**
     * Setup before tests
     */
    @Before
    public void setUp(){

        reviewList = new ReviewList();
        ReviewList.setContext(new DeleteReviewActivity());
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
    }

    /**
     * Test deleteBelowThree method
     */
    @Test
    public void testDelete(){
        assertEquals(4, reviewList.sizeofList());
        deleteReviewUseCase.delete(3);
    }

}