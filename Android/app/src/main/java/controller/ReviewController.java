package controller;

import use_case.review.DeleteReviewInputBoundary;
import use_case.review.DeleteReviewUseCase;
import use_case.review.ReviewList;

/**
 * Controller class for use_case.review.
 */


public class ReviewController {
    private static ReviewList reviews;
    /**
     * The input use_case.boundary for delete use_case.review use case.
     */
    private final DeleteReviewInputBoundary deleteReviewInputBoundary;
    /**
     * Reading from file constructor.
     */
    public ReviewController() {
        reviews = new ReviewList();
        /*
          The input use_case.boundary for delete use_case.review use case.
         */
        this.deleteReviewInputBoundary = new DeleteReviewUseCase(reviews);
    }


    /**
     *
     * @param name name of the customer.
     * @param ifAnonymous whether the use_case.review is anonymous.
     * @param rate the rate of the use_case.review.
     * @param comment comments left.

     */
    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment, String ID) {
        reviews.addReview(name, ifAnonymous, rate, comment, ID);
    }


    /**
     *
     * @return the length of the use_case.review list.
     */
    public int length() {
        return reviews.sizeofList();
    }


    /**
     *
     * Delete all reviews with rate below or equal to 3.
     */
    public void deleteBelowThree() {
        deleteReviewInputBoundary.delete(3);
    }


    /**
     *
     * Delete all reviews with rate below or equal to 2.
     */
    public void deleteBelowTwo() {deleteReviewInputBoundary.delete(2);}


    /**
     *
     * Delete all reviews with rate below or equal to 1.
     */
    public void deleteBelowOne() {deleteReviewInputBoundary.delete(1);}
}
