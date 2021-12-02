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
public class ReviewList implements Serializable {
    private static HashMap<Integer, ArrayList<Review>> reviews;
    private ReviewOutputBoundary reviewOutputBoundary;

    /**
     * Empty constructor.
     */
    public ReviewList() {
    }

    public static void setReviews(HashMap<Integer, ArrayList<Review>> reviews) {
        ReviewList.reviews = reviews;
    }


    public void addReview(String name, boolean ifAnonymous, int rate, String comment, boolean ifComplain, String complain){
        addReview(new Review(name, ifAnonymous, rate, comment, ifComplain, complain));
    }
    /**
     * Add review to this review list.
     *
     * @param r is the review to add in the list
     */
    public void addReview(Review r) {
        if(reviews.containsKey(r.getRate())){
            Objects.requireNonNull(reviews.get(r.getRate())).add(r);
        } else {
            ArrayList<Review> review = new ArrayList<>();
            review.add(r);
            reviews.put(r.getRate(), review);
        }
    }

    public void setReviewOutputBoundary(ReviewOutputBoundary reviewOutputBoundary){
        this.reviewOutputBoundary = reviewOutputBoundary;
    }

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
        StringBuilder menuString = new StringBuilder();
        for (int review : reviews.keySet()) {
            menuString.append(reviewNumber).append(". ").append(Objects.requireNonNull(reviews.get(review)));
            reviewNumber++;
        }
        return menuString.toString();
    }


    /**
     *
     * Delete all reviews with rate below or equal to 3.
     */
    public void deleteBelowThree() {
        reviews.put(3, new ArrayList<>());
        reviews.put(2, new ArrayList<>());
        reviews.put(1, new ArrayList<>());
    }


    /**
     *
     * Delete all reviews with rate below or equal to 2.
     */
    public void deleteBelowTwo() {
        reviews.put(2, new ArrayList<>());
        reviews.put(1, new ArrayList<>());
    }


    /**
     *
     * Delete all reviews with rate below or equal to 1.
     */
    public void deleteBelowOne() {
        reviews.put(1, new ArrayList<>());
    }

    public void reviewAsString() {
        reviewOutputBoundary.updateReviewDisplay(this.toString());
    }
}