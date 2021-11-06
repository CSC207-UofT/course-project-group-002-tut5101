package controller;
import constant.FileLocation;

import entity.Review;
import use_case.ReviewList;
import gateway.ReviewReadWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewController {
    private static HashMap map;
    private static ReviewList reviews;
    private static ReviewReadWriter rrw = new ReviewReadWriter();

    public ReviewController(){
        map = rrw.readFromFile(FileLocation.REVIEW_LIST_LOCATION);
        reviews = new ReviewList(map);
    }

    public void saveToFile(){
        rrw.saveToFile(FileLocation.REVIEW_LIST_LOCATION,map);
    }

    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment, boolean ifComplain, String complaint){
        reviews.addReview(ReviewList.creatReview(name, ifAnonymous, rate, comment, ifComplain,complaint));
    }
}
