package use_case.boundary.input;

/**
 * The input use_case.boundary for PlaceOrder use case.
 */

public interface DeleteReviewInputBoundary {
    void deleteBelowThree();
    void deleteBelowTwo();
    void deleteBelowOne();
}
