package entities;

public class Review{
    /**
     * @param review The the comment that user want to input
     * @param user_id The user id
     */
    public String user_id;
    public String review;
    public boolean YorN;
    public boolean YorNforStuff;
    public String complainStuff;


    public Review(String review, String user_id, boolean YorN, boolean YorNforStuff, String complainStuff){
        this.review = review;
        this.user_id = user_id;
        this.YorN = YorN;
        this.YorNforStuff = YorNforStuff;
        this.complainStuff = complainStuff;
    }

    public String ShowReview(){
        if (this.YorN){
            return user_id + ":" + review + ".";
        }else{
            return "anonymous" + ":" + review + ".";
        }
    }

    public String ComplainStuff(){
        if (this.YorNforStuff){
            if (this.YorN){
                return "anonymous" + ":" + complainStuff + ".";
            } else {
                return user_id + ":" + complainStuff + ".";
            }
        } else {
            return null;
        }
    }



}
