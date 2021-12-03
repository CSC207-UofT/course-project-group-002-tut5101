package use_case.review;

import androidx.annotation.NonNull;
import entity.review.Review;

import java.io.Serializable;
import java.util.HashMap;
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
        reviews = new HashMap<>();
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
     * @param ifAnonymous whether use_case.review is anonymous.
     * @param rate rate of the use_case.review.
     * @param comment comment left.
     */
    public void addReview(String name, boolean ifAnonymous, int rate, String comment, String ID){
        addReview(new Review(name, ifAnonymous, rate, comment, ID));
    }

    /**
     * Add use_case.review to this use_case.review list.
     *
     * @param r is the use_case.review to add in the list
     */
    public void addReview(Review r) {
        reviews.put(r.getReviewID(), r);
    }

    /**
     *
     * @param reviewOutputBoundary setting the output boundary for use_case.review.
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
     * @return the size of the use_case.review list.
     */
    public int sizeofList(){
        return reviews.size();
    }

    public static HashMap<String, Review> getAllReviews(){
        return reviews;
    }

    /**
     *
     * @return a string representation of this use_case.review list.
     */
    @Override
    @NonNull
    public String toString() {
        StringBuilder reviewString = new StringBuilder();
        for (String review : reviews.keySet()) {
            reviewString.append(Objects.requireNonNull(reviews.get(review)));
        }
        return reviewString.toString();
    }


    /**
     * pass use_case.review as string.
     */
    public void reviewAsString() {
        reviewOutputBoundary.updateReviewDisplay(this.toString());
    }
}