package use_case;

import boundary.DeleteReviewInputBoundary;
import constant.FileLocation;
import gateway.ReadWriter;
import gateway.ReviewReadWriter;

public class DeleteReviewUseCase implements DeleteReviewInputBoundary {

    private ReviewList reviewList;

    /**
     * Constructor
     * @param reviewList The list of review
     */
    public DeleteReviewUseCase(ReviewList reviewList) {
        this.reviewList = reviewList;
    }

    /**
     * Delete reviews from a reviewList
     */
    public void deleteReview() {
        reviewList.deleteReviews();

    }
}
