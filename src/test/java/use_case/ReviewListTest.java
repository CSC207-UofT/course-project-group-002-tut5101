package use_case;
import constant.fileSystem.FileLocation;
import entity.review.Review;
import use_case.reviewList.ReviewList;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ReviewListTest {
    ReviewList rl = new ReviewList();

    @Before
    public void setUp(){
        rl.addReview(new Review("Amy", false, 5, "good", false, ""));
        rl.addReview(new Review("Ben", false, 5, "good", false, ""));
        rl.addReview(new Review("Cissy", true, 1, "not good", true, "bad"));
    }

    @Test
    public void testSaveToFile() throws IOException {
        ReviewReadWriter readWriter = new ReviewReadWriter();
        readWriter.saveToFile(FileLocation.REVIEW_LIST_LOCATION, rl);
    }

    @Test
    public void testReadFromFile(){
        ReviewReadWriter urf = new ReviewReadWriter();
        ReviewList rl = new ReviewList(urf.readFromFile(FileLocation.USER_FILE_LOCATION));
        System.out.println(rl);
    }

}
