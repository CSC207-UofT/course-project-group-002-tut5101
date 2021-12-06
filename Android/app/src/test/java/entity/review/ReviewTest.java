package entity.review;


import android.annotation.SuppressLint;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Review Class
 *
 */
public class ReviewTest {
    private Review review1;
    private Review review2;
    private Review review3;

    /**
     * setup before tests
     */
    @Before
    public void setUp() {
        review1 = new Review("Amy", true, 5, "good food",
                "1");
        review2 = new Review("Bob", false, -1, "Nice staff",
                "2");
        review3 = new Review("Amy", true, 3, "good food",
                "1");
    }

    /**
     * Test getName method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetName() {
        assertEquals("Anonymous", review1.getName());
        assertEquals("Bob", review2.getName());
    }

    /**
     * Test getRate method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetRate() {
        assertEquals(5, review1.getRate());
        assertEquals(0, review2.getRate());
        assertEquals(3, review3.getRate());
    }

    /**
     * Test getComment method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetComment() {
        assertEquals("good food", review1.getComment());
    }

    /**
     * Test getComment method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetID() {
        assertEquals("1", review1.getReviewID());
    }

    /**
     * Test getReviewDate method for use_case.review
     */
    @Test(timeout = 50)
    public void testGetReviewDate() {
        Date expected = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String actual = review1.getReviewDate();
        assertEquals(dateFormat.format(expected), actual);
    }

    /**
     * Test toString method for use_case.review
     */
    @Test(timeout = 50)
    public void testToString() {
        String expected = "Anonymous leaves rate = 5 and comment = good food" + "\n";
        String actual = review1.toString();
        assertEquals(expected, actual);
    }

}