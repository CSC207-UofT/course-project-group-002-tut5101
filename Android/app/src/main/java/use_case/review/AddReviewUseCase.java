package use_case.review;

import android.content.Context;

/**
 * Use Case class for adding reviews.
 */
public class AddReviewUseCase implements AddReviewInputBoundary{
    private final ReviewList reviewList;

    /**
     * Constructor
     */
    public AddReviewUseCase(Context context) {
        this.reviewList = new ReviewList(context);
    }


    /**
     * adding the review to reviewList.
     *
     * @param name name of review
     * @param ifAnonymous if anonymous of review
     * @param rate rate of review
     * @param comment comment of review
     * @param ID id of review
     */
    @Override
    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment, String ID) {
        reviewList.addReview(name, ifAnonymous, rate, comment, ID);
    }

    /**
     *
     * @return length of the reviewList.
     */
    @Override
    public int length() {
        return reviewList.sizeofList();
    }
}
