package use_case.review;

import android.annotation.SuppressLint;
import entity.review.Review;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


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

        TestClass testPresenter = new TestClass();
        reviewList.setReviewOutputBoundary(testPresenter);
    }

    /**
     * Test the setReviews method
     */
    @Test
    public void testSetReviews() {
        HashMap<String, Review> reviews = new HashMap<>();
        reviews.put("1", review1);
        ReviewList.setReviews(reviews);
        assertEquals(1, reviewList.sizeofList());
    }
    /**
     * Test the add review method
     */
    @Test
    public void testAddReview() {
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        reviewList.addReview("Amy", true, 5, "good food", "1");
    }

    /**
     * Test the sizeOfList method
     */
    @Test
    public void testSizeOfList(){
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        assertEquals(2, reviewList.sizeofList());
    }

    /**
     * Test the reviewAsString method
     */
    @Test
    public void testReviewAsString() {
        reviewList.reviewAsString();
    }


    /**
     * Test the toString method
     */
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


    /**
     * Empty fake presenter class implementing the output boundary
     */
    private static class TestClass implements ReviewOutputBoundary {

        /**
         * Test if this method is called
         * @param toString string to display
         */
        @Override
        public void updateReviewDisplay(String toString) {
            assert true;
        }
    }
}