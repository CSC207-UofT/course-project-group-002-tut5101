package entity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Review implements UserName, Rate, Comment, ComplainStuff, DayTime{
    public String userName;
    public boolean ifAnonymous;
    public int rate;
    public String newComment;
    public boolean ifComplain;
    public String newComplain;

    /**
     * Construct an instance of Material
     * @param userName The name of the user
     * @param ifAnonymous ture if the user want to anonymous, false if the user want to show the userName
     * @param rate an int in 0-5 rate for the food
     * @param newComment The comment that the user want to add
     * @param ifComplain true if the user want to add complain to stuff, false if the user doesn't want to
     * @param newComplain the complain that the user want to add
     */

    public Review(String userName, boolean ifAnonymous, int rate, String newComment,
                  boolean ifComplain, String newComplain){
        this.userName = userName;
        this.ifAnonymous = ifAnonymous;
        this.rate = rate;
        this.newComment = newComment;
        this.ifComplain = ifComplain;
        this.newComplain = newComplain;
    }


    /**
     * Get the name of the user
     * @return The String of the userName, return "Anonymous" if the user want to anonymous.
     */
    @Override
    public String addName() {
        if(ifAnonymous){
            return "Anonymous";
        } else {
            return userName;
        }
    }


    /**
     * Get the rate of the comment
     * @return an int of the rate from 0-5.
     */
    @Override
    public int addRate() {
        if (rate <= 0){
            return 0;
        } else return Math.min(rate, 5);

    }


    /**
     * Get the comment of the user
     * @return The String of the comment.
     */
    @Override
    public String addComment() {
        return newComment;
    }


    /**
     * Get the complain for the stuff.
     * @return The String of the complain.
     */
    @Override
    public String complainStuff() {
        if(ifComplain){
            return newComplain;
        }else {
            return "no complain";
        }
    }


    /**
     * Get the date when the user comment
     * @return The LocalDateTime when the user makes a comment.
     */
    @Override
    public String reviewDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public String toString(){
        return addName()+ ";"+ this.rate + ";"+ this.newComment +";"+ this.newComplain+";"+ reviewDate();
    }
}

