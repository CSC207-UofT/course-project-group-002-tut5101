package gateway;
import use_case.UserList;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;


public interface ReadWriter {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o) throws IOException;

    /**
     * @param filepath location of ser file
     */
    Serializable readFromFile(String filepath) throws IOException, ClassNotFoundException;
}
