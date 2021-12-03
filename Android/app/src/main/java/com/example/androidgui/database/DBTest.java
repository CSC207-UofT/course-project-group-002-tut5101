package com.example.androidgui.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DBTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
    }

    /**
     * Button onclick listener
     * @param view android view
     */
    public void getData(View view) {

        try {
            URL url = new URL("https://storage.googleapis.com/207project/WQ11.txt");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


//
//        StringBuilder urls = new StringBuilder();
//        try {
//            // Create a URL for the desired page
//            URL url = new URL("https://storage.googleapis.com/207project/WQ11.txt");
//            //First open the connection
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(60000); // timing out in a minute
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//            String str;
//            while ((str = in.readLine()) != null) {
//                urls.append(str);
//            }
//            System.out.println(urls);
//            in.close();
//        } catch (Exception e) {
//            Log.d("MyTag", e.toString());
//        }
    }

    /**
     * Button onclick listener
     * @param view android view
     */
    public void uploadFile(View view) {
    }
}