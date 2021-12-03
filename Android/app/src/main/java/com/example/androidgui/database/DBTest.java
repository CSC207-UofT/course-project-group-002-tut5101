package com.example.androidgui.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBTest extends AppCompatActivity {

    private static String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
    }

    public static void setData(String responseData) {
        data = responseData;
    }

    /**
     * Button onclick listener
     *
     * @param view android view
     */
    public void getData(View view) {
        new Thread(() -> {

            StringBuilder urlResponse = new StringBuilder();
            try {
                // Create a URL for the desired page
                URL url = new URL("https://storage.googleapis.com/project207/CarlSagan.txt");
                //First open the connection
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(60000); // timing out in a minute

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String str;
                while ((str = in.readLine()) != null) {
                    urlResponse.append(str);
                }
                System.out.println(urlResponse);
                DBTest.setData(urlResponse.toString());
                in.close();
            } catch (Exception e) {
                Log.d("MyTag", e.toString());
            }

        }).start();
    }

    /**
     * Button onclick listener
     *
     * @param view android view
     */
    public void uploadFile(View view) {



        File dir = new File(DBTest.this.getFilesDir(), "textDir");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File txtFile = new File(dir, "Carl.txt");
        try {
            FileWriter writer = new FileWriter(txtFile);
            writer.append(DBTest.data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}