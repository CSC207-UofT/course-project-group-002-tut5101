package use_case.review.boundaries;

/**
 * The input boundary for deleting review use case.
 */

public interface DeleteReviewInputBoundary {

    /**
     * Delete reviews.
     *
     * @param i rate to delete.
     */
    void delete(int i);

}
