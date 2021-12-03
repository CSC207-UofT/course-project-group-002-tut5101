package use_case.review;

/**
 * The input use_case.boundary for adding review use case.
 */
public interface AddReviewInputBoundary {

    /**
     *
     * @param name name of review
     * @param ifAnonymous if anonymous of review
     * @param rate rate of review
     * @param comment comment of review
     * @param ID id of review
     */
    void addToReviewList(String name, boolean ifAnonymous, int rate,
                    String comment, String ID);

    /**
     *
     * @return the length of the reviewList.
     */
    int length();
}
