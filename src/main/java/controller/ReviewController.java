package controller;
import constant.FileLocation;

import entity.Review;
import use_case.ReviewList;
import gateway.ReviewReadWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewController {
    public void saveToFile(String filePath){
        ReviewList rl = new ReviewList();
        rl.SavetoFile(filePath);
    }

    public void addToReviewList(Review r){
        ReviewList rl = new ReviewList();
        rl.addReview(r);
    }
}
