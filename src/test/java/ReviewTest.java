/**
 * Tests for Review Class
 *
 * @author Mingyang Li
 */

import entity.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReviewTest {
    Review review1;

    @Before
    public void setUp() {
        review1 = new Review();
    }

    @Test(timeout = 50)
    public void testReviewAddName() {
        assertEquals(review1.addName("Amy", true), "Anonymous");
    }

    @Test(timeout = 50)
    public void testReview2() {
        assertEquals(review1.addName("Amy", false), "Amy");
    }
}