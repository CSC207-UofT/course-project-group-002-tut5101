package controller.reviewSystem;

import constant.fileSystem.FileLocation;
import use_case.reviewList.ReviewList;

/**
 * Controller class for review.
 */


public class ReviewController {
    private final String filepath;
    private static ReviewList reviews;

    /**
     * Reading from file constructor.
     */
    public ReviewController() {
        this.filepath = FileLocation.REVIEW_LIST_LOCATION;
        reviews = new ReviewList(this.filepath);
    }

    //TODO: delete this useless constructor?
    /**
     *
     * @param filepath default constructor.
     */
    public ReviewController(String filepath) {
        this.filepath = filepath;
        reviews = new ReviewList(filepath);
    }

    /**
     *
     * @param name name of the customer.
     * @param ifAnonymous whether the review is anonymous.
     * @param rate the rate of the review.
     * @param comment comments left.
     * @param ifComplain whether the customer complains.
     * @param complaint if complains, content of the complaint.
     */
    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment, boolean ifComplain, String complaint) {
        reviews.addReview(name, ifAnonymous, rate, comment, ifComplain, complaint);
    }

    /**
     * save the reviewList to file.
     */
    public void saveToFile(){
        reviews.saveToFile();}

    /**
     *
     * @return a string representation of the reviewList.
     */
    public String reviewsAsString() {
        return reviews.toString();
    }
}
