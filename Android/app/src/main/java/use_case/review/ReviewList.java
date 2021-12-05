package use_case.review;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import constant.file_system.FileName;
import entity.review.Review;
import gateway.GCloudReadWriter;
import gateway.ReadWriter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * A list of reviews.
 */
public class ReviewList implements Serializable, Iterable<Review> {
    private static HashMap<String, Review> reviews;
    private ReviewOutputBoundary reviewOutputBoundary;
    private static ReadWriter irw;
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
    @NonNull
    @Override
    public ReviewListIterator iterator(){return new ReviewListIterator();}

    /**
     *
     * @return the size of the use_case.review list.
     */
    public int sizeofList(){
        return reviews.size();
    }

    /**
     *
     * @return the review List.
     */
    public static HashMap<String, Review> getAllReviews(){
        return reviews;
    }

    /**
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
     * pass use_case.review as string.
     */
    public void reviewAsString() {
        reviewOutputBoundary.updateReviewDisplay(this.toString());
    }

    /**
     * Saving to file.
     */
    public void saveToFile() {
        irw.saveToFile(context, filename, reviews);
    }

    /**
     * Generating data.
     */
    @SuppressWarnings("unchecked")
    public void generateData() {
        reviews = (HashMap<String, Review>) irw.readFromFile(FileName.REVIEW_FILE);
    }

    /**
     * Setting context.
     * @param context context
     */
    public static void setContext(Context context) {
        ReviewList.context = context;
    }


    /**
     * Reading data
     * @param filename the name of the data file
     */
    public static void setData(String filename) {
        ReviewList.filename = filename;
        ReviewList.irw = new GCloudReadWriter();
        reviews = (HashMap<String, Review>) irw.readFromFile(filename);
    }
}