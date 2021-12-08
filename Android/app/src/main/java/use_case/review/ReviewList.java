package use_case.review;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import entity.review.Review;
import gateway.GCloudReadWriter;
import gateway.ReadWriter;
import use_case.review.boundaries.ReviewOutputBoundary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * A list of reviews.
 */
public class ReviewList implements Serializable, Iterable<Review> {
    private static HashMap<String, Review> reviews;
    private ReviewOutputBoundary reviewOutputBoundary;
    private static final ReadWriter irw = new GCloudReadWriter();
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private static String filename;

    /**
     * Null constructor for testing
     */
    public ReviewList() {
        if (reviews == null) {
            reviews = new HashMap<>();
        }
    }

    /**
     * Resets the reviewList for tests
     */
    public void reset() {
        reviews = new HashMap<>();
    }


    /**
     * Set review list to the given list.
     *
     * @param reviews setting the reviews.
     */
    public static void setReviews(HashMap<String, Review> reviews) {
        ReviewList.reviews = reviews;
    }


    /**
     * Add review to the review list.
     *
     * @param name        name.
     * @param ifAnonymous return use_case.review is anonymous or not.
     * @param rate        rate of the use_case.review.
     * @param comment     comment left.
     */
    public void addReview(String name, boolean ifAnonymous, int rate, String comment) {
        addReview(new Review(name, ifAnonymous, rate, comment, String.valueOf(this.sizeofList() + 1)));
    }

    /**
     * Add use_case.review to this use_case.review list.
     *
     * @param r is the use_case.review to add in the list
     */
    public void addReview(Review r) {
        reviews.put(r.getReviewID(), r);
        saveToFile();
    }

    /**
     * Set output boundary.
     *
     * @param reviewOutputBoundary setting the output boundary for use_case.review.
     */
    public void setReviewOutputBoundary(ReviewOutputBoundary reviewOutputBoundary) {
        this.reviewOutputBoundary = reviewOutputBoundary;
    }

    /**
     * Returns an iterator for this reviewList.
     *
     * @return an iterator for this reviewList.
     */
    @NonNull
    @Override
    public ReviewListIterator iterator() {
        return new ReviewListIterator();
    }

    /**
     * Return number of reviews in the list.
     *
     * @return the size of the use_case.review list.
     */
    public int sizeofList() {
        return reviews.size();
    }

    /**
     * Return all reviews
     *
     * @return the review List.
     */
    public static HashMap<String, Review> getAllReviews() {
        return reviews;
    }

    /**
     * Return string presentation of review list.
     *
     * @return a string representation of this use_case.review list.
     */
    @NonNull
    @Override
    public String toString() {
        StringBuilder reviewString = new StringBuilder();
        for (String review : reviews.keySet()) {
            reviewString.append(Objects.requireNonNull(reviews.get(review)));
        }
        return reviewString.toString();
    }


    /**
     * Pass review as string.
     */
    public void reviewAsString() {
        reviewOutputBoundary.updateReviewDisplay(this.toString());
    }

    /**
     * Saving to file.
     */
    public static void saveToFile() {
        irw.saveToFile(context, filename, reviews);
    }


    /**
     * Setting context.
     *
     * @param context context
     */
    public static void setContext(Context context) {
        ReviewList.context = context;
    }


    /**
     * Reading data
     *
     * @param filename the name of the data file
     */
    @SuppressWarnings("unchecked")
    public static void setData(String filename) {
        ReviewList.filename = filename;
        if (reviews == null || reviews.isEmpty()) {
            reviews = (HashMap<String, Review>) irw.readFromFile(filename);
        }
    }

    /**
     * Delete the given review
     *
     * @param review review to be deleted.
     */
    public static void delete(Review review) {
        reviews.remove(review.getReviewID());
    }
}