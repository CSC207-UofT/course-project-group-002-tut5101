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
    public String userName;
    public boolean ifAnonymous;
    public int rate;
    public String newComment;
    public boolean ifComplain;
    public String newComplain;

    /**
     * Construct an instance of Material
     *
     * @param userName    The name of the user
     * @param ifAnonymous ture if the user want to anonymous, false if the user want to show the userName
     * @param rate        an int in 0-5 rate for the food
     * @param newComment  The comment that the user want to add
     * @param ifComplain  true if the user want to add complain to stuff, false if the user doesn't want to
     * @param newComplain the complain that the user want to add
     */

    public Review(String userName, boolean ifAnonymous, int rate, String newComment,
                  boolean ifComplain, String newComplain) {
        this.userName = userName;
        this.ifAnonymous = ifAnonymous;
        this.rate = rate;
        this.newComment = newComment;
        this.ifComplain = ifComplain;
        this.newComplain = newComplain;
    }


    /**
     * Get the name of the user
     *
     * @return The String of the userName, return "Anonymous" if the user want to anonymous.
     */
    @Override
    public String addName() {
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
    public int addRate() {
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
    public String addComment() {
        return newComment;
    }


    /**
     * Get the complain for the stuff.
     *
     * @return The String of the complain.
     */
    @Override
    public String complainStuff() {
        if (ifComplain) {
            return newComplain;
        } else {
            return "no complaint";
        }
    }


    /**
     * Get the date when the user comment
     *
     * @return The LocalDateTime when the user makes a comment.
     */
    @Override
    public String reviewDate() {
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    @NonNull
    public String toString() {
        return addName() + ";" + this.rate + ";" + this.newComment + ";" + this.newComplain + ";" + reviewDate();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isIfAnonymous() {
        return ifAnonymous;
    }

    public void setIfAnonymous(boolean ifAnonymous) {
        this.ifAnonymous = ifAnonymous;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
    }

    public boolean isIfComplain() {
        return ifComplain;
    }

    public void setIfComplain(boolean ifComplain) {
        this.ifComplain = ifComplain;
    }

    public String getNewComplain() {
        return newComplain;
    }

    public void setNewComplain(String newComplain) {
        this.newComplain = newComplain;
    }
}

