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

public class GCloudReadWriter implements ReadWriter {

    private Object currentDS;

    public Object readFromFile(String filename) {

        new Thread(() -> {
            try {
                URL url = new URL("https://storage.googleapis.com/207project/" + filename);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(60000);

                InputStream file = conn.getInputStream();
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer);

                this.currentDS = input.readObject();
                input.close();
            } catch (IOException | ClassNotFoundException e) {
                Log.d("MyTag", e.toString());
            }
        }).start();

        return currentDS;
    }

    public void saveToFile(Context context, String filename, Object map) {
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

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
