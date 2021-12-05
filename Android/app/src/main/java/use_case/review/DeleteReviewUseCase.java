package use_case.review;

import android.content.Context;
import entity.review.Review;

import java.util.Iterator;

/**
 *
 * Use case class for deleting use_case.review functionality.
 */
@SuppressWarnings("FieldMayBeFinal")
public class DeleteReviewUseCase implements DeleteReviewInputBoundary {
    private final ReviewList reviewList;

    /**
     * Constructor
     */
    public DeleteReviewUseCase() {
        this.reviewList = new ReviewList();
    }

    /**
     * Setting context
     * @param context context.
     */
    public void setContext(Context context){
        this.reviewList.setContext(context);
    }

    /**
     *
     * Delete all reviews with rate below or equal to 3.
     */
    @Override
    public void delete(int i) {
        Iterator<Review> reviewIterator = reviewList.iterator();
        while (reviewIterator.hasNext()){
            Review review = reviewIterator.next();
            if (review != null && review.getRate() < i + 1) {
                reviewIterator.remove();
//                readWriter.saveToFile(reviewList);
            }
        }
    }

}
