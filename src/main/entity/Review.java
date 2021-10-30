package entity;

import java.time.LocalDateTime;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Objects;

public class Review implements userName, Rate, Comment, ComplainStuff, DayTime{

    @Override
    public String addName(String name, boolean ifAnonymous) {
        if(ifAnonymous){
            return "Anonymous";
        } else {
            return name;
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
        return newComment;
    }

    @Override
    public String complainStuff(boolean ifComplain, String newComplain) {
        if(ifComplain){
            return newComplain;
        }else {
            return "";
        }
    }

    @Override
    public LocalDateTime reviewDate() {
        return LocalDateTime.now();
    }


}

