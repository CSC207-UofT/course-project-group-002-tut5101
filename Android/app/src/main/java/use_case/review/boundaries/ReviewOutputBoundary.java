package use_case.review.boundaries;

/**
 * The output boundary for review presenter.
 */
public interface ReviewOutputBoundary {
    /**
     * Request the updated review to display.
     *
     * @param toString string representation of the reviews.
     */
    void updateReviewDisplay(String toString);
}
