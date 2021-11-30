package use_case.review;

import use_case.boundary.input.DeleteReviewInputBoundary;

@SuppressWarnings("FieldMayBeFinal")
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
