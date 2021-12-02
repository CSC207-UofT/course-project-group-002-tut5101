package use_case.review;

import androidx.annotation.NonNull;
import entity.review.Review;
import use_case.boundary.output.ReviewOutputBoundary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A list of reviews.
 */
public class ReviewList implements Serializable, Iterable<Review> {
    private static HashMap<String, Review> reviews;
    private ReviewOutputBoundary reviewOutputBoundary;

    /**
     * Empty constructor.
     */
    public ReviewList() {
    }

    /**
     *
     * @param reviews setting the reviews.
     */
    public static void setReviews(HashMap<String, Review> reviews) {
        ReviewList.reviews = reviews;
    }


    /**
     *
     * @param name name.
     * @param ifAnonymous whether review is anonymous.
     * @param rate rate of the review.
     * @param comment comment left.
     */
    public void addReview(String name, boolean ifAnonymous, int rate, String comment, String ID){
        addReview(new Review(name, ifAnonymous, rate, comment, ID));
    }

    /**
     * Add review to this review list.
     *
     * @param r is the review to add in the list
     */
    public void addReview(Review r) {
        reviews.put(r.getReviewID(), r);
    }

    /**
     *
     * @param reviewOutputBoundary setting the output boundary for review.
     */
    public void setReviewOutputBoundary(ReviewOutputBoundary reviewOutputBoundary){
        this.reviewOutputBoundary = reviewOutputBoundary;
    }

    /**
     * Returns an iterator for this reviewList.
     *
     * @return an iterator for this reviewList.
     */
    @Override
    @NonNull
    public ReviewListIterator iterator(){return new ReviewListIterator();}

    /**
     *
     * @return the size of the review list.
     */
    public int sizeofList(){
        return reviews.size();
    }

    /**
     *
     * @return a string representation of this review list.
     */
    @NonNull
    @Override
    public String toString() {
        int reviewNumber = 1;
        StringBuilder reviewString = new StringBuilder();
        for (String review : reviews.keySet()) {
            reviewString.append(reviewNumber).append(". ").append(Objects.requireNonNull(reviews.get(review)));
            reviewNumber = reviewNumber + 1;
        }
        return reviewString.toString();
    }


    /**
     * pass review as string.
     */
    public void reviewAsString() {
        reviewOutputBoundary.updateReviewDisplay(this.toString());
    }
}