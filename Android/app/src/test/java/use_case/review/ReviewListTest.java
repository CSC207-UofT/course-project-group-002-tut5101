package use_case.review;

import entity.review.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing reviewList.
 */
public class ReviewListTest {
    final ReviewList reviewList = new ReviewList();

    /**
     * Setting up.
     */
    @Before
    public void setUp(){
        Review r1 = new Review("1", false, 5, "nice",  "1");
        Review r2 = new Review("2", false, 4, "nice",  "2");
        Review r3 = new Review("3", false, 3, "nice",  "3");
        Review r4 = new Review("4", false, 2, "nice",  "4");
        Review r5 = new Review("5", false, 1, "nice", "5");
        Review r6 = new Review("6", false, 2, "nice", "6");
        Review r7 = new Review("7", false, 3, "nice", "7");
        Review r8 = new Review("8", false, 4, "nice", "8");
        Review r9 = new Review("9", false, 5, "nice", "9");
        Review r10 = new Review("10", false, 2, "nice", "10");
        reviewList.addReview(r1);
        reviewList.addReview(r2);
        reviewList.addReview(r3);
        reviewList.addReview(r4);
        reviewList.addReview(r5);
        reviewList.addReview(r6);
        reviewList.addReview(r7);
        reviewList.addReview(r8);
        reviewList.addReview(r9);
        reviewList.addReview(r10);
    }

    /**
     *
     * Testing toString method.
     */
    @Test
    public void testToString() {
        assertEquals(reviewList.toString(),
                "1. 1: rate = 5; comment = nice ;2021-12-022. " +
                "2: rate = 4; comment = nice ;2021-12-023. " +
                "3: rate = 3; comment = nice ;2021-12-024. " +
                "4: rate = 2; comment = nice ;2021-12-025. " +
                "5: rate = 1; comment = nice ;2021-12-026. " +
                "6: rate = 2; comment = nice ;2021-12-027. " +
                "7: rate = 3; comment = nice ;2021-12-028. " +
                "8: rate = 4; comment = nice ;2021-12-029. " +
                "9: rate = 5; comment = nice ;2021-12-0210. " +
                "10: rate = 2; comment = nice ;2021-12-02");
    }




}
