package use_case;

import entity.Review;
import java.io.*;
import java.util.ArrayList;

public class ReadandWriteReview implements ReadWriteReview<Object> {
    @Override
    public Object read(String filepath) {
        String line;
        ArrayList<String> reviews = new ArrayList<String>();
        Review r = new Review();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while((line = br.readLine()) != null){
                reviews.add(line);
            }
            br.close();
            return reviews;
        } catch (IOException e){ e.printStackTrace();}
        return r;
    }

    @Override
    public void addReivew(String filepath, String content) {
        try {
            FileWriter writer = new FileWriter(filepath, true);
            writer.write(content+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
