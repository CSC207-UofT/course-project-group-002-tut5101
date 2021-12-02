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
    public int curr = 0;
    public static HashMap<String, Review> reviewList;

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
            List<String> lst = new ArrayList<>(reviewList.keySet());
            String reviewName = lst.get(curr);
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
        Iterator.super.remove();
    }
}
