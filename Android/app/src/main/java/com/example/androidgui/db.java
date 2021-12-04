package com.example.androidgui;

import android.app.Activity;
import android.net.Uri;
import android.os.Looper;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.common.collect.Lists;
import gateway.FetchData;
import gateway.PutData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class db extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        try {
//            authExplicit();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        readFile();

    }


    public void readFile() {
        new Thread(new Runnable() {

            public void run() {

                StringBuilder urls = new StringBuilder();
                try {
                    // Create a URL for the desired page
                    URL url = new URL("https://storage.googleapis.com/207project/sample.ser"); //My text file location
                    //First open the connection
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(60000); // timing out in a minute

//                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//                    String str;
//                    while ((str = in.readLine()) != null) {
//                        urls.append(str);
//                    }
//                    System.out.println("READING:" + urls);
//                    in.close();
                    InputStream file = conn.getInputStream();
                    InputStream buffer = new BufferedInputStream(file);
                    ObjectInput input = new ObjectInputStream(buffer);

                    // serialize the Map
                    HashMap result = (HashMap) input.readObject();
                    System.out.println("READ RESULT:" + result);
                    input.close();

                } catch (IOException | ClassNotFoundException e) {
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


    public void writeFile(String FILE_URL, String FILE_NAME) {

        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
        }
    }


    /**
     *
     * @param projectId The project id
     * @param bucketName The unique bucket name
     * @param objectName Object name
     * @param filePath path to the file
     * @throws IOException
     */
    public void uploadObject(
            String projectId, String bucketName, String objectName, String filePath) throws IOException {

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    authExplicit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("did1");
                Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
                System.out.println("did2");
                BlobId blobId = BlobId.of(bucketName, objectName);
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
                System.out.println("did3");
                storage.create(blobInfo, new byte[]{0, 1, 2, 3});
                System.out.println("did4");
                // storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));

                System.out.println("File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);

                //since we are in background thread, to post results we have to go back to ui thread. do the following for that
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        System.out.println(urls);
//                    }
//                });
            }
        }).start();
    }

    void authExplicit() throws IOException {
        // You can specify a credential file by providing a path to GoogleCredentials.
        // Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS environment variable.

        new Thread(new Runnable() {

            @Override
            public void run() {
                GoogleCredentials credentials = null;
                try {
                    credentials = GoogleCredentials.fromStream(getAssets().open("uplifted-cinema-252918-80dc77e32e4e.json"))
                            .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
                    Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
                    BlobId blobId = BlobId.of("207project", "sample.ser");
                    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

                    HashMap<Integer, Integer> test = new HashMap<>();
                    test.put(1, 2);
                    test.put(2, 4);
                    test.put(3, 9);
                    test.put(4, 16);
                    test.put(5, 25);

                    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                    ObjectOutputStream out = new ObjectOutputStream(byteOut);
                    out.writeObject(test);
                    System.out.println("BYTE:" + byteOut);
                    storage.create(blobInfo, byteOut.toByteArray());

//                    String test = "asdfasfdjkalsdfklasdjkfalsdfjkasldfjaklsdjfkalsdf";
//                    storage.create(blobInfo, test.getBytes());
//                    System.out.println("WRITING:" + test.getBytes());
                    // storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));
                    // storage.create(blobInfo, Files.readAllBytes(getAssets().open("inventory.ser")));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
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
//        https://cloud.google.com/artifact-registry/docs/java/authentication#gcloud
//        https://github.com/pliablematter/simple-cloud-storage

}

