package use_case;
import constant.FileLocation;
import entity.Review;
import gateway.ReviewReadWriter;
import gateway.UserReadWriter;
import use_case.ReviewList;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ReviewListTest {
    ReviewList rl = new ReviewList();

    @Before
    public void setUp(){
        rl.addReview(new entity.Review("Amy", false, 5, "good", false, ""));
        rl.addReview(new entity.Review("Ben", false, 5, "good", false, ""));
        rl.addReview(new entity.Review("Cissy", true, 1, "not good", true, "bad"));
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
