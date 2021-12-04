package com.example.androidgui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.HashMap;

//public class db extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        authExplicit();
//        readFile();
//
//    }


//    public void readFile() {
//        new Thread(new Runnable() {
//
//            public void run() {
//
//                StringBuilder urls = new StringBuilder();
//                try {
//                    URL url = new URL("https://storage.googleapis.com/207project/sample.ser");
//                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    conn.setConnectTimeout(60000);
//
////                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
////
////                    String str;
////                    while ((str = in.readLine()) != null) {
////                        urls.append(str);
////                    }
////                    System.out.println("READING:" + urls);
////                    in.close();
//                    InputStream file = conn.getInputStream();
//                    InputStream buffer = new BufferedInputStream(file);
//                    ObjectInput input = new ObjectInputStream(buffer);
//
//                    // serialize the Map
//                    HashMap result = (HashMap) input.readObject();
//                    System.out.println("READ RESULT:" + result);
//                    input.close();
//
//                } catch (IOException | ClassNotFoundException e) {
//                    Log.d("MyTag", e.toString());
//                }
//
//                //since we are in background thread, to post results we have to go back to ui thread. do the following for that
////                runOnUiThread(new Runnable() {
////                    public void run() {
////                        System.out.println(urls);
////                    }
////                });
//
//            }
//        }).start();
//    }
//
//    void authExplicit() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                GoogleCredentials credentials = null;
//                try {
//                    credentials = GoogleCredentials.fromStream(getAssets().open("uplifted-cinema-252918-80dc77e32e4e.json"))
//                            .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//                    Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//                    BlobId blobId = BlobId.of("207project", "sample.ser");
//                    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
//
//                    HashMap<Integer, Integer> test = new HashMap<>();
//                    test.put(1, 2);
//                    test.put(2, 4);
//                    test.put(3, 9);
//                    test.put(4, 16);
//                    test.put(5, 25);
//
//                    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
//                    ObjectOutputStream out = new ObjectOutputStream(byteOut);
//                    out.writeObject(test);
//                    System.out.println("BYTE:" + byteOut);
//                    storage.create(blobInfo, byteOut.toByteArray());
//
////                    String test = "Testing string";
////                    storage.create(blobInfo, test.getBytes());
////                    System.out.println("WRITING:" + test.getBytes());
//                    // storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));
//                    // storage.create(blobInfo, Files.readAllBytes(getAssets().open("inventory.ser")));
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

//}

