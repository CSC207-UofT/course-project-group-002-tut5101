package gateway;

import android.content.Context;
import android.util.Log;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

public class AndroidReadWriter {
    public void writeToFile(HashMap data, Context context, String fileName) {
        try {
            File file = new File(context.getFilesDir(), fileName);
            Log.e("LOG", String.valueOf(file.exists()));
            Log.e("LOG", String.valueOf(file.getAbsolutePath()));
            if(!file.exists()) {
                file.createNewFile();
                Log.e("LOG", "File created");
            }

            ObjectOutput output = new ObjectOutputStream(new FileOutputStream(file));

            output.writeObject(data);
            output.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


    public HashMap readFromFile(Context context, String fileName) {

        String ret = "";
        HashMap result = null;

        try {
            // InputStream inputStream = context.getAssets().open("users.ser");

            File file = new File(context.getFilesDir(), fileName);
            Log.e("LOG", String.valueOf(file.exists()));
            Log.e("LOG", String.valueOf(file.getAbsolutePath()));

            FileInputStream f = new FileInputStream(file);
            ObjectInput output = new ObjectInputStream(f);
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
