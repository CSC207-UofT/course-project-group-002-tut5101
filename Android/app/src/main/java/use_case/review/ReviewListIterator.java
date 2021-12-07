package use_case.review;

import entity.review.Review;

import java.util.*;

/**
 * An iterator for ReviewList.
 */
public class ReviewListIterator implements Iterator<Review> {

    /**
     * The index of the next use_case.review to return.
     */
    private int curr = 0;
    private static HashMap<String, Review> reviewList;
    private static List<String> lstReviews;


    /**
     * Constructor for this iterator.
     */
    public ReviewListIterator() {
        reviewList = ReviewList.getAllReviews();
        lstReviews = new ArrayList<>(reviewList.keySet());
    }


    /**
     * Returns whether there is another Review to return.
     *
     * @return whether there is another Review to return.
     */
    @Override
    public boolean hasNext() {
        return curr < reviewList.size();
    }

    /**
     * Returns the next use_case.review.
     *
     * @return the next use_case.review.
     */
    @Override
    public Review next() {
        Review review;
        try {
            String reviewName = lstReviews.get(curr);
            review = reviewList.get(reviewName);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        curr += 1;
        return review;
    }

    /**
     * Remove the current use_case.review.
     */
    @Override
    public void remove() {
        String reviewName = lstReviews.get(curr);
        String reviewID = Objects.requireNonNull(reviewList.get(reviewName)).getReviewID();
        ReviewList.getAllReviews().remove(reviewID);
    }
}
