package gateway;

import android.content.Context;
import android.util.Log;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class GCloudReadWriter implements ReadWriter {

    public HashMap readFromFile(String filename) {
        new Thread(() -> {
            try {
                URL url = new URL("https://storage.googleapis.com/207project/" + filename);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(60000);

//                StringBuilder urls = new StringBuilder();
//                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//                String str;
//                while ((str = in.readLine()) != null) {
//                    urls.append(str);
//                }
//                System.out.println("READING:" + urls);
//                in.close();
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

        }).start();
    }

    public void saveToFile(Context context, String filename, HashMap map) {
        new Thread(() -> {
            GoogleCredentials credentials;
            try {
                credentials = GoogleCredentials.fromStream(context.getAssets().open("uplifted-cinema-252918-80dc77e32e4e.json"))
                        .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
                Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
                BlobId blobId = BlobId.of("207project", filename);
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOut);
                out.writeObject(map);
                System.out.println("BYTE:" + byteOut);
                storage.create(blobInfo, byteOut.toByteArray());

//                    String test = "Testing string";
//                    storage.create(blobInfo, test.getBytes());
//                    System.out.println("WRITING:" + test.getBytes());
                // storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));
                // storage.create(blobInfo, Files.readAllBytes(getAssets().open("inventory.ser")));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
