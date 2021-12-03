package use_case.review;

import android.annotation.SuppressLint;
import entity.review.Review;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Test the ReviewList class
 */
public class ReviewListTest {
    private ReviewList reviewList;
    private Review review1;
    private Review review2;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        reviewList = new ReviewList();
        review1 = new Review("Amy", true, 5, "good food", "1");
        review2 = new Review("Bob", false, 5, "Nice staff",
                "2");
    }

    @Test
    public void testAddReview() {
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        reviewList.addReview("Amy", true, 5, "good food", "1");
    }

    @Test
    public void testSizeOfList(){
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        assertEquals(2, reviewList.sizeofList());
    }

    @Test
    public void testToString(){
        reviewList.addReview(review1);
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String review = "1" + ". " + "Anonymous" + ": rate = " + "5" +
                "; comment = " + "good food" + " ;" + dateFormat.format(date);

        String actual = reviewList.toString();
        assert(actual.contains(review));
    }

}