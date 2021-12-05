package gateway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData extends Thread {
    public final String url;
    String data = "Empty";

    public FetchData(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            HttpURLConnection inputConnection = (HttpURLConnection) url.openConnection();
            InputStream input = inputConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder result = new StringBuilder();
            String read_line;
            while ((read_line = reader.readLine()) != null) {
                result.append(read_line);
            }
            input.close();
            reader.close();
            inputConnection.disconnect();
            setData(result.toString());
        } catch (IOException e) {
            setData(e.toString());
        }
    }

    public boolean startFetch() {
        FetchData.this.start();
        return true;
    }

    public boolean onComplete() {
        while (true) {
            if (!this.isAlive()) {
                return true;
            }
        }
    }

    public String getResult() {
        return this.getData();
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getData() {
        return data;
    }
}