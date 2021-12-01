package use_case;
import entity.review.Review;
import use_case.review.ReviewList;
import org.junit.Before;
import org.junit.Test;

public class ReviewListTest {
    final ReviewList rl = new ReviewList();

    @Before
    public void setUp(){
        rl.addReview(new Review("Amy", false, 5, "good", false, ""));
        rl.addReview(new Review("Ben", false, 5, "good", false, ""));
        rl.addReview(new Review("Cissy", true, 1, "not good", true, "bad"));
    }



}
