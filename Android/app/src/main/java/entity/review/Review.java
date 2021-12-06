package entity.review;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Entity class for reviews.
 */

public class Review implements Reviewable, Serializable {
    private final String userName;
    private final boolean ifAnonymous;
    private final int rate;
    private final String newComment;
    private final String reviewID;

    /**
     * Construct an instance of Material
     *
     * @param userName    The name of the user
     * @param ifAnonymous ture if the user want to anonymous, false if the user want to show the userName
     * @param rate        an int in 0-5 rate for the food
     * @param newComment  The comment that the user want to add
     */

    public Review(String userName, boolean ifAnonymous, int rate, String newComment, String ID) {
        this.userName = userName;
        this.ifAnonymous = ifAnonymous;
        this.rate = rate;
        this.newComment = newComment;
        this.reviewID = ID;
    }

    /**
     *
     * @return id of the use_case.review.
     */
    public String getReviewID() {
        return reviewID;
    }

    /**
     * Get the name of the user
     *
     * @return The String of the userName, return "Anonymous" if the user want to anonymous.
     */
    @Override
    public String getName() {
        if (ifAnonymous) {
            return "Anonymous";
        } else {
            return userName;
        }
    }


    /**
     * Get the rate of the comment
     *
     * @return an int of the rate from 0-5.
     */
    @Override
    public int getRate() {
        if (rate <= 0) {
            return 0;
        } else return Math.min(rate, 5);
    }


    /**
     * Get the comment of the user
     *
     * @return The String of the comment.
     */
    @Override
    public String getComment() {
        return newComment;
    }

    /**
     * Get the date when the user comment
     *
     * @return The LocalDateTime when the user makes a comment.
     */
    @Override
    public String getReviewDate() {
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     *
     * @return a string representation of this use_case.review.
     */
    @Override
    @NonNull
    public String toString() {
        return getName() + " leaves rate = " + this.rate +
                " and comment = " + this.newComment + "\n";
    }

}

