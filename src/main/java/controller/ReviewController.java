package controller;
import constant.FileLocation;

import entity.Review;
import use_case.ReviewList;
import gateway.ReviewReadWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewController {
    private static ReviewReadWriter rrw = new ReviewReadWriter();
    private static HashMap map;
    private  static  ReviewList reviews;

    public ReviewController(){
        map = rrw.readFromFile(FileLocation.REVIEW_LIST_LOCATION);
        reviews = new ReviewList(map);
    }

    public void saveToFile(String filePath){ rrw.saveToFile(filePath, map);}


    public void addToReviewList(Review r){
        ReviewList rl = new ReviewList();
        rl.addReview(r);
    }
}
