package entity.review_system;

/**
 * Interface of reviewable.
 */


public interface Reviewable {
    String getName();

    int getRate();

    String getReviewDate();

    String getComment();
}
