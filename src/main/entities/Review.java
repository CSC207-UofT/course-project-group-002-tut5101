package entities;

import java.util.Objects;

public class Review{
    public String user_name;
    public String if_anonymous;

    public Review(String name, String YorN){
        this.user_name = name;
        this.if_anonymous = YorN;
    }

    public String is_anonymous(){
        if(Objects.equals(this.if_anonymous, "YES")){
            return "anonymous";
        } else{
            return this.user_name;
        }
    }

}
