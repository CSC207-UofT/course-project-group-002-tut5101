package use_case.review;

import android.content.Context;

/**
 * The input use_case.boundary for deleting review use case.
 */

public interface DeleteReviewInputBoundary {

    /**
     * delete reviews.
     *
     * @param i rate to delete.
     */
    void delete(int i);

    void setContext(Context context);
}
