package use_case.review;

import use_case.boundary.input.DeleteReviewInputBoundary;

@SuppressWarnings("FieldMayBeFinal")
public class DeleteReviewUseCase implements DeleteReviewInputBoundary {

    private final ReviewList reviewList;

    /**
     * Constructor
     * @param reviewList The list of review
     */
    public DeleteReviewUseCase(ReviewList reviewList) {
        this.reviewList = reviewList;
    }


    /**
     *
     * Delete all reviews with rate below or equal to 3.
     */
    @Override
    public void deleteBelowThree() {
        reviewList.deleteBelowThree();
    }


    /**
     *
     * Delete all reviews with rate below or equal to 2.
     */
    @Override
    public void deleteBelowTwo() {
        reviewList.deleteBelowTwo();
    }


    /**
     *
     * Delete all reviews with rate below or equal to 1.
     */
    @Override
    public void deleteBelowOne() {
        reviewList.deleteBelowOne();
    }
}
