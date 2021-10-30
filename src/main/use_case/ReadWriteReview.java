package use_case;
import entity.Review;

import java.io.IOException;

public interface ReadWriteReview<T> {
    T read(String filepath);
    void addReivew(String filepath, String content);
}
