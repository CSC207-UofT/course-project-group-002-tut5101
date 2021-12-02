package com.example.androidgui;

import android.app.Activity;
import android.os.Looper;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import gateway.FetchData;
import gateway.PutData;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class db extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {

            public void run() {

                StringBuilder urls = new StringBuilder();
                try {
                    // Create a URL for the desired page
                    URL url = new URL("https://storage.googleapis.com/207project/WQ11.txt"); //My text file location
                    //First open the connection
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(60000); // timing out in a minute

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String str;
                    while ((str = in.readLine()) != null) {
                        urls.append(str);
                    }
                    System.out.println(urls);
                    in.close();
                } catch (Exception e) {
                    Log.d("MyTag", e.toString());
                }

                //since we are in background thread, to post results we have to go back to ui thread. do the following for that
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        System.out.println(urls);
//                    }
//                });

            }
        }).start();
    }

    public static void uploadObject(
            String projectId, String bucketName, String objectName, String filePath) throws IOException {
        // The ID of your GCP project
        // String projectId = "your-project-id";

        // The ID of your GCS bucket
        // String bucketName = "your-unique-bucket-name";

        // The ID of your GCS object
        // String objectName = "your-object-name";

        // The path to your file to upload
        // String filePath = "path/to/your/file"

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));

        System.out.println(
                "File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);
    }


//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//
//        StrictMode.setThreadPolicy(policy);
//
//        try {
//            URL url = new URL("http://207project.infinityfreeapp.com/test.txt");
//
//            StringBuilder sb = new StringBuilder();
//            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                sb.append(line + System.lineSeparator());
//            }
//
//            System.out.println(sb.toString());
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                FetchData fetchData = new FetchData("http://207project.infinityfreeapp.com/GetData.php");
//                if (fetchData.startFetch()) {
//                    if (fetchData.onComplete()) {
//                        String result = fetchData.getResult();
//                        Log.i("FetchData", result);
//                    }
//                }
//            }
//        }, 3000);
//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php",
//                        "POST", "Raymond", "124");
//                System.out.println("did");
//                if (putData.startPut()) {
//                    if (putData.onComplete()) {
//                        String result = putData.getResult();
//                        Log.i("PutData", result);
//                    }
//                }
//                //End Write and Read data with URL
//            }
//        }, 3000);

//        https://github.com/VishnuSivadasVS/Advanced-HttpURLConnection
//        https://stackoverflow.com/questions/6343166/how-can-i-fix-android-os-networkonmainthreadexception

}