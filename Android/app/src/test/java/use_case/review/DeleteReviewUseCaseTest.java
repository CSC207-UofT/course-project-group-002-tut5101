package use_case.review;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.example.android.review_activities.DeleteReviewActivity;
import constant.file_system.FileName;
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
        ReviewList.setData("TEST"+FileName.REVIEW_FILE);
        ReviewList.setContext(new DeleteReviewActivity());
        reviewList.reset();
        Review review1 = new Review("Amy", true, 5, "good food",
                "1");
        Review review2 = new Review("Bob", false, 4, "Nice staff",
                "2");
        Review review3 = new Review("3", true, 3, "good food",
                "3");
        Review review4 = new Review("4", true, 2, "4",
                "4");
        Review review5 = new Review("5", true, 2, "5",
                "5");
        Review review6 = new Review("6", true, 1, "6",
                "6");
        reviewList.addReview(review5);
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        reviewList.addReview(review3);
        reviewList.addReview(review4);
        reviewList.addReview(review6);
        deleteReviewUseCase = new DeleteReviewUseCase();
    }

    /**
     * Test deleteBelowThree method
     */
    @Test
    public void testDelete(){
        assertEquals(6, reviewList.sizeofList());
        deleteReviewUseCase.delete(1);
        assertEquals(5, reviewList.sizeofList());
        deleteReviewUseCase.delete(2);
        assertEquals(3, reviewList.sizeofList());
        deleteReviewUseCase.delete(3);
        assertEquals(2, reviewList.sizeofList());
    }

}