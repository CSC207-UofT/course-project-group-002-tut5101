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

    /**
     * setup before tests
     */
    @Before
    public void setUp() {
        review1 = new Review("Amy", true, 5, "good food",
                true, "bad stuff");
        review2 = new Review("Bob", false, -1, "Nice staff",
                false,"good");
    }

    /**
     * Test getName method for review
     */
    @Test(timeout = 50)
    public void testReviewGetName() {
        assertEquals("Anonymous", review1.getName());
        assertEquals("Bob", review2.getName());
    }

    /**
     * Test getRate method for review
     */
    @Test(timeout = 50)
    public void testReviewGetRate() {
        assertEquals(5, review1.getRate());
        assertEquals(0, review2.getRate());
    }

    /**
     * Test getComment method for review
     */
    @Test(timeout = 50)
    public void testReviewGetComment() {
        assertEquals("good food", review1.getComment());
    }

    /**
     * Test complainStuff method for review
     */
    @Test(timeout = 50)
    public void testReviewComplainStuff() {
        assertEquals("bad stuff", review1.complainStuff());
        assertEquals("no complaint", review2.complainStuff());
    }

    /**
     * Test getReviewDate method for review
     */
    @Test(timeout = 50)
    public void testGetReviewDate() {
        Date expected = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String actual = review1.getReviewDate();
        assertEquals(dateFormat.format(expected), actual);
    }

    /**
     * Test toString method for review
     */
    @Test(timeout = 50)
    public void testToString() {
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expected = "Anonymous" + ";" + 5 + ";" + "good food" + ";" + "bad stuff" + ";" + dateFormat.format(date);
        String actual = review1.toString();
        assertEquals(expected, actual);
    }

}