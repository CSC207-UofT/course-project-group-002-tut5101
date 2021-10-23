package entity;

public class Review implements Rate, Comment, ComplainStuff{

    public String user_id;
    public String review;
    public boolean YorN;
    public boolean YorNforStaff;
    public String complainStaff;

    /**
     * @param review The the comment that user want to input
     * @param user_id The user id
     * @param YorN whether a Yes or No
     * @param YorNforStaff whether a Yes or No for staff
     * @param complainStaff the complain for a staff
     */


    public Review(String review, String user_id, boolean YorN, boolean YorNforStaff, String complainStaff){
        this.review = review;
        this.user_id = user_id;
        this.YorN = YorN;
        this.YorNforStaff = YorNforStaff;
        this.complainStaff = complainStaff;
    }

    /**
     * Get the Review of a user
     * @return The review of a user.
     */


    public String ShowReview(){
        if (this.YorN){
            return user_id + ":" + review + ".";
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
            if (this.YorN){
                return "anonymous" + ":" + complainStaff + ".";
            } else {
                return user_id + ":" + complainStaff + ".";
            }
        } else {
            return null;
        }
    }

    @Override
    public int addRate(int number) {
        return number;
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

}
