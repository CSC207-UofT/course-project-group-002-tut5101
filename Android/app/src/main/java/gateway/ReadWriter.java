package gateway;
/**
 * Gateway interface for reading and writing.
 */


import android.content.Context;

import java.util.HashMap;

public interface ReadWriter {
    /**
     * @param context an activity instance
     * @param filename the name of the file
     * @param map the HashMap to be saved
     */
    void saveToFile(Context context, String filename, HashMap map);

    /**
     * @param filename the name of the file
     */
    HashMap readFromFile(String filename);
}
