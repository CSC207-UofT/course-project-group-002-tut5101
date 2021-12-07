package use_case.review;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.example.android.review_activities.AddReviewCommentActivity;
import constant.file_system.FileName;
import entity.review.Review;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * Test the AffReviewUseCase class
 */
public class AddReviewUseCaseTest {
    private AddReviewUseCase add;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    /**
     * Setup before tests
     */
    @Before
    public void setUp(){
        ReviewList reviewList = new ReviewList();
        ReviewList.setContext(new AddReviewCommentActivity());
        ReviewList.setData("TEST"+FileName.REVIEW_FILE);
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
        add.addToReviewList("amy", true, 1,"dog");
    }

}
