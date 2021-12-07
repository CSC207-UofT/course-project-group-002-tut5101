package use_case.review;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.example.android.review_activities.SeeReviewActivity;
import constant.file_system.FileName;
import entity.review.Review;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import use_case.review.boundaries.ReviewOutputBoundary;

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
    private Review review3;
    private Review review4;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        reviewList = new ReviewList();
        ReviewList.setContext(new SeeReviewActivity());
        ReviewList.setData("TEST"+FileName.REVIEW_FILE);
        reviewList.reset();
        review1 = new Review("Amy", true, 5, "good food", "1");
        review2 = new Review("Bob", false, 4, "Nice staff",
                "2");
        review3 = new Review("Cathy", false, 3, "Nice staff",
                "3");
        review4 = new Review("David", false, 2, "Nice staff",
                "4");

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
    }

    /**
     * Test the sizeOfList method
     */
    @Test
    public void testSizeOfList(){
        reviewList.reset();
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        reviewList.addReview(review3);
        reviewList.addReview(review4);
        assertEquals(4, reviewList.sizeofList());
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
        reviewList.addReview(review2);
        String review = "Anonymous leaves rate = 5 and comment = good food\n" +
                "Bob leaves rate = 4 and comment = Nice staff\n";

        String actual = reviewList.toString();
        assertEquals(actual, review);
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
     * Test delete method.
     */
    @Test
    @SuppressWarnings("AccessStaticViaInstance")
    public void delete(){
        reviewList.reset();
        reviewList.addReview(review1);
        reviewList.addReview(review2);
        reviewList.addReview(review3);
        reviewList.addReview(review4);
        reviewList.delete(review3);
        assertEquals(3, reviewList.sizeofList());
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