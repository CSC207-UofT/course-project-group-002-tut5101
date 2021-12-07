package entity.review;

/**
 * Interface of reviewable.
 */


@SuppressWarnings("unused")
public interface Reviewable {
    String getName();

    int getRate();

    String getReviewDate();

    String getComment();
}
