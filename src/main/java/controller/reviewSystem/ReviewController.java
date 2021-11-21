package controller.reviewSystem;

import constant.fileSystem.FileLocation;
import use_case.reviewList.ReviewList;

/**
 * Controller class for review.
 */


public class ReviewController {
    private final String filepath;
    private static ReviewList reviews;


    public ReviewController() {
        this.filepath = FileLocation.REVIEW_LIST_LOCATION;
        reviews = new ReviewList(this.filepath);
    }

    public ReviewController(String filepath) {
        this.filepath = filepath;
        reviews = new ReviewList(filepath);
    }


    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment, boolean ifComplain, String complaint) {
        reviews.addReview(name, ifAnonymous, rate, comment, ifComplain, complaint);
    }

    public int sizeofReview(){
        return this.reviews.sizeofList();
    }

    public void saveToFile(){
        reviews.saveToFile();}
}
