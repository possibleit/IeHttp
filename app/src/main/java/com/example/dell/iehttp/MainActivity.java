package com.example.dell.iehttp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.iehttp.IeHttp.LeHttp;
import com.example.dell.iehttp.IeHttp.LeJsonDataTransform;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String url = "http://ip.taobao.com/service/getIpInfo2.php?ip=myip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequest();
    }

    private void sendRequest(){
        LeHttp.sendJsonRequest(url, null, ResposeCalss.class, new LeJsonDataTransform<ResposeCalss>() {
            @Override
            public void onSuccess(ResposeCalss m) {
                Log.e("test", m.toString());
            }

            @Override
            public void onFailure() {
                Log.i("test","failure");
            }
        });
    }
}
