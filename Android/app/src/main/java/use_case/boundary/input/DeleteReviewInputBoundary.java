package use_case.boundary.input;

/**
 * The input use_case.boundary for PlaceOrder use case.
 */

public interface DeleteReviewInputBoundary {

    /**
     * delete reviews.
     *
     * @param i rate to delete.
     */
    void delete(int i);
}
