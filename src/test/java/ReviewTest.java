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
        review1 = new Review("ok", "Ben", false, true, "bad");

    }

    @Test(timeout = 50)
    public void testReview1() {
        assertEquals(review1.ShowReview(), "anonymous:ok.");
    }

    @Test(timeout = 50)
    public void testReview2() {
        assertEquals(review1.ComplainStaff(), "anonymous:bad.");
    }
}