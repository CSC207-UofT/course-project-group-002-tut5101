/**
 * Tests for Review Class
 *
 * @author Mingyang Li
 */

import entities.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReviewTest {
    Review review1;

    @Before
    public void setUp() {
        review1 = new Review("ok", "Ben", false);

    }

    @Test(timeout = 50)
    public void testReview() {
        assertEquals(review1.showReview(), "anonymous:ok.");
    }
}