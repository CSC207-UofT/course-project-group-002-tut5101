package use_case;
import entity.review.Review;
import use_case.review.ReviewList;
import org.junit.Before;
import org.junit.Test;

public class ReviewListTest {
    ReviewList rl = new ReviewList();

    @Before
    public void setUp(){
        rl.addReview(new Review("Amy", false, 5, "good", false, ""));
        rl.addReview(new Review("Ben", false, 5, "good", false, ""));
        rl.addReview(new Review("Cissy", true, 1, "not good", true, "bad"));
    }


    @Test
    public void testReadFromFile(){

        ReviewList rl = new ReviewList();
        System.out.println(rl);
    }

    @Test
    public void testToString(){
        System.out.println(rl);
    }

}
