package use_case.review;

import entity.review.Review;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ReviewListIteratorTest {
    private ReviewListIterator reviewListIterator;

    @Before
    public void setUp() {
        HashMap<String, Review> reviews = new HashMap<>();
        Review testReview = new Review("1", true, 5, "", "1");
        reviews.put("1", testReview);
        ReviewList.setReviews(reviews);
        reviewListIterator = new ReviewListIterator();
    }

    @Test
    public void hasNext() {
        reviewListIterator.hasNext();
    }

    @Test
    public void next() {
        reviewListIterator.next();
    }

    @Test
    public void remove() {
        reviewListIterator.remove();
    }
}