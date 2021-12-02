package entity.review;

/**
 * Interface of reviewable.
 */


public interface Reviewable {
    String getName();

    int getRate();

    String getReviewDate();

    String complainStuff();

    String getComment();
}
