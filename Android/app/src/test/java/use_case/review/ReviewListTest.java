package use_case.review;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.example.androidgui.manager_activities.SeeReviewActivity;
import constant.file_system.FileName;
import entity.review.Review;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.HashMap;
import java.util.Iterator;


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
        ReviewList.setContext(new SeeReviewActivity());
        review1 = new Review("Amy", true, 5, "good food", "1");
        review2 = new Review("Bob", false, 5, "Nice staff",
                "2");

        TestClass testPresenter = new TestClass();
        reviewList.setReviewOutputBoundary(testPresenter);
    }

    /**
     * For testing
     */
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

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
        reviewList.reset();
        reviewList.addReview(review1);
        String review = "1" + ". " + "Anonymous" + ": rate = " + "5" +
                "; comment = " + "good food";

        String actual = reviewList.toString();
        assertFalse(actual.contains(review));
    }

    /**
     * Test the getAllReviews method
     */
    @Test
    public void testGetAllReviews() {
        HashMap<String, Review> expected = new HashMap<>();
        expected.put("1", review1);
        expected.put("2", review2);
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        assertEquals(expected, ReviewList.getAllReviews());
    }

    /**
     * Test the next method for review iterator
     */
    @Test
    public void testIteratorNext() {
        Iterator<Review> reviewIterator = reviewList.iterator();
        while (reviewIterator.hasNext()){
            reviewIterator.next();
        }
        try {
            reviewIterator.next();
            assert false;
        }
        catch (Exception ignored){
            assert true;
        }
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