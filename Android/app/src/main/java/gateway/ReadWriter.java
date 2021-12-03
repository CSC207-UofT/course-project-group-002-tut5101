package gateway;
/**
 * Gateway interface for reading and writing.
 */


import java.util.HashMap;

public interface ReadWriter {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o);

    /**
     * @param filepath location of ser file
     */
    HashMap readFromFile(String filepath);
}

