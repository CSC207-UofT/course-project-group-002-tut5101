package use_case.review;

import android.content.Context;
import constant.file_system.FileLocation;

/**
 * Use Case class for adding reviews.
 */
public class AddReviewUseCase implements AddReviewInputBoundary{
    private final ReviewList reviewList;

    /**
     * Constructor
     */
    public AddReviewUseCase() {
        this.reviewList = new ReviewList(FileLocation.REVIEW_FILE);
    }

    /**
     * Setting context
     * @param context context.
     */
    public void setContext(Context context){
        this.reviewList.setContext(context);
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
