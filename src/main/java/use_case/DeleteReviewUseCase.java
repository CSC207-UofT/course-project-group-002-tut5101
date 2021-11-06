package use_case;

import boundary.DeleteReviewInputBoundary;
import constant.FileLocation;
import gateway.ReadWriter;
import gateway.ReviewReadWriter;


public class DeleteReviewUseCase implements DeleteReviewInputBoundary {

    private ReviewList reviewList;

    public DeleteReviewUseCase(ReviewList reviewList) {
        this.reviewList = reviewList;
    }

    public void deleteReview() {
        reviewList.deleteReviews();

    }
}
