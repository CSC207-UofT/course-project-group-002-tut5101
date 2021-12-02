package com.example.androidgui;

import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import gateway.FetchData;
import gateway.PutData;


public class db extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                FetchData fetchData = new FetchData("http://207project.infinityfreeapp.com/GetData.php");
                if (fetchData.startFetch()) {
                    if (fetchData.onComplete()) {
                        String result = fetchData.getResult();
                        Log.i("FetchData", result);
                    }
                }
            }
        }, 3000);

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
}
}