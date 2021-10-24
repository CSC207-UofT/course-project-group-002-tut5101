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
        review1 = new Review("Ben");

    }

    @Test(timeout = 50)
    public void testisAnonymouse() {
        assertEquals(review1.isAnonymouse(true), "Anonymous");
    }

    @Test(timeout = 50)
    public void testReviewRate() {
        assertEquals(review1.addRate(6), 5);
    }

    @Test(timeout = 50)
    public void testReviewComment() {
        assertEquals(review1.addComment("ok"), "ok");
    }

    @Test(timeout = 50)
    public void testComplainStuff() {
        assertEquals(review1.complainStuff("bad"), "bad");
    }




}