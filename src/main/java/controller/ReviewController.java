package controller;
import constant.FileLocation;
import use_case.ReviewList;
import java.text.SimpleDateFormat;
import gateway.ReviewReadWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewController {

    public void addToReviewList
            (String name, boolean ifAnonymouse, int rate, String comment, boolean ifComplain, String complain) {
        ReviewList rl = new ReviewList();
        rl.addReview(rl.creatReview(name, ifAnonymouse, rate, comment, ifComplain, complain));
        rl.SavetoFile("src/main/resources/review.ser");
    }

}
