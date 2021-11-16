package controller;

import constant.FileLocation;
import gateway.ReviewReadWriter;
import use_case.ReviewList;

import java.util.HashMap;

/**
 * Controller class for review.
 */


public class ReviewController {
    private static HashMap map;
    private static ReviewList reviews;
    private static ReviewReadWriter rrw = new ReviewReadWriter();

    public ReviewController() {
        map = rrw.readFromFile(FileLocation.REVIEW_LIST_LOCATION);
        reviews = new ReviewList(map);
    }

    public void saveToFile() {
        rrw.saveToFile(FileLocation.REVIEW_LIST_LOCATION, map);
    }

    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment, boolean ifComplain, String complaint) {
        reviews.addReview(name, ifAnonymous, rate, comment, ifComplain, complaint);
    }
}
