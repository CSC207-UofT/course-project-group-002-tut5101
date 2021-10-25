package entity;

import use_case.Customer;

import java.time.LocalDateTime;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class Review implements Rate, Comment, ComplainStuff, DayTime{

    public String userId;
    public String review;
    public boolean IfAnonymous;
    public boolean YorNforStaff;
    public String complainStaff;

    /**
     * @param review The the comment that user want to input
     * @param userID The user id
     * @param IsAnonymous whether a Yes or No for anonymous
     * @param YorNforStaff whether a Yes or No for complain staff
     * @param complainStaff the complain for a staff
     */


    public Review(String review, String userID, boolean IsAnonymous, boolean YorNforStaff, String complainStaff){
        this.review = review;
        this.userId = userID;
        this.IfAnonymous = IsAnonymous;
        this.YorNforStaff = YorNforStaff;
        this.complainStaff = complainStaff;
    }

    /**
     * Get the Review of a user
     * @return The review of a user.
     */


    public String ShowReview(){
        if (this.IfAnonymous){
            return userId + ":" + review + ".";
        }else{
            return "anonymous" + ":" + review + ".";
        }
    }

    /**
     * Get the complain for a staff
     * @return The complain for a staff.
     */


    public String ComplainStaff(){
        if (this.YorNforStaff){
            if (this.IfAnonymous){
                return "anonymous" + ":" + complainStaff + ".";
            } else {
                return userId + ":" + complainStaff + ".";
            }
        } else {
            return null;
        }
    }

    @Override
    public int addRate(int number) {
        if (number <= 0){
            return 0;
        } else return Math.min(number, 5);

    }

    @Override
    public String addComment(String newComment) {
        review = newComment;
        return review;
    }

    @Override
    public String complainStuff(String newComplain) {
        complainStaff = newComplain;
        return complainStaff;
    }

    @Override
    public LocalDateTime reviewDate() {
        return LocalDateTime.now();
    }

}

