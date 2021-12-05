package gateway;


import java.util.HashMap;


/**
 * Gateway interface for reading and writing.
 */

public interface ReadWriter {

    void saveToFile(Object o);

    HashMap<String, Object> readFromFile();
}

