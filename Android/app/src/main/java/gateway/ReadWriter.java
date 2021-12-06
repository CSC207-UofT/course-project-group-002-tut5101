package gateway;

import android.content.Context;

/**
 * Gateway interface for reading and writing.
 */

public interface ReadWriter {
    /**
     * @param context an activity instance
     * @param filename the name of the file
     * @param map the HashMap to be saved
     */
    void saveToFile(Context context, String filename, Object map);

    /**
     * @param filename the name of the file
     */
    Object readFromFile(String filename);
}
