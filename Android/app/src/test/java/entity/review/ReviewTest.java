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
        review3 = new Review("Coc", true, 100, "",
                "3");
    }

    /**
     * Test getName method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetName1() {
        assertEquals("Anonymous", review1.getName());
    }

    /**
     * Test getName method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetName2() {
        assertEquals("Bob", review2.getName());
    }

    /**
     * Test getName method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetName3() {
        assertEquals("Anonymous", review3.getName());
    }

    /**
     * Test getRate method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetRate1() {
        assertEquals(5, review1.getRate());
    }

    /**
     * Test getRate method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetRate2() {
        assertEquals(0, review2.getRate());
    }

    /**
     * Test getRate method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetRate3() {
        assertEquals(5, review3.getRate());
    }

    /**
     * Test getComment method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetComment1() {
        assertEquals("good food", review1.getComment());
    }

    /**
     * Test getComment method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetComment2() {
        assertEquals("Nice staff", review2.getComment());
    }

    /**
     * Test getComment method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetComment3() {
        assertEquals("", review3.getComment());
    }

    /**
     * Test getReviewID method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetID1() {
        assertEquals("1", review1.getReviewID());
    }

    /**
     * Test getReviewID method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetID2() {
        assertEquals("2", review2.getReviewID());
    }

    /**
     * Test getReviewID method for use_case.review
     */
    @Test(timeout = 50)
    public void testReviewGetID3() {
        assertEquals("3", review3.getReviewID());
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
    public void testToString1() {
        String expected = "Anonymous leaves rate = 5 and comment = good food";
        String actual = review1.toString();
        assertEquals(expected, actual);
    }

    /**
     * Test toString method for use_case.review
     */
    @Test(timeout = 50)
    public void testToString2() {
        String expected = "Bob leaves rate = 0 and comment = Nice staff";
        String actual = review2.toString();
        assertEquals(expected, actual);
    }

    /**
     * Test toString method for use_case.review
     */
    @Test(timeout = 50)
    public void testToString3() {
        String expected = "Anonymous leaves rate = 5 and comment = ";
        String actual = review3.toString();
        assertEquals(expected, actual);
    }

}