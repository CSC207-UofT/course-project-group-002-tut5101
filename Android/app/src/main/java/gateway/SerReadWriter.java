package gateway;

import android.content.Context;

import java.io.*;
import java.util.HashMap;

/**
 * Gateway class for user reading and writing.
 */


public class SerReadWriter implements ReadWriter {

    /**
     * save the data to file.
     */
    @Override
    public void saveToFile(Context context, String s, Object o) {

        try {
            OutputStream file = new FileOutputStream("change");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            // serialize the Map
            output.writeObject("change");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return a hashmap read from url.
     */
    @Override
    public HashMap<String, Object> readFromFile(String s) {
        HashMap<String, Object> users = new HashMap<>();
        try {
            File f = new File("change");
            f.createNewFile();
            InputStream file = new FileInputStream(f);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            users = (HashMap<String, Object>) input.readObject();
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
