package use_case.boundary.input;

/**
 * The input use_case.boundary for PlaceOrder use case.
 */

public interface DeleteReviewInputBoundary {

    /**
     *
     * Delete all reviews with rate below or equal to 3.
     */
    void deleteBelowThree();

    /**
     *
     * Delete all reviews with rate below or equal to 2.
     */
    void deleteBelowTwo();

    /**
     *
     * Delete all reviews with rate below or equal to 1.
     */
    void deleteBelowOne();
}
