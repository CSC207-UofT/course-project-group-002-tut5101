package gateway;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

public class AndroidReadWriter {
    public void writeToFile(HashMap data, Context context, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open("inventory.ser");

            //ObjectOutput output = new ObjectOutputStream(new FileOutputStream());

//            output.writeObject(data);
//            output.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


    public HashMap readFromFile(Context context, String fileName) {

        String ret = "";
        HashMap result = null;

        try {
            InputStream inputStream = context.getAssets().open(fileName);

            ObjectInput output = new ObjectInputStream(inputStream);
            result = (HashMap) output.readObject();
            output.close();

        }
        catch (ClassNotFoundException | FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return result;
    }
}
