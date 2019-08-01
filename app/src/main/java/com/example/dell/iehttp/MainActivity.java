package com.example.dell.iehttp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.iehttp.IeHttp.JsonCallbackListener;
import com.example.dell.iehttp.IeHttp.LeHttp;
import com.example.dell.iehttp.IeHttp.LeJsonDataTransform;
import com.example.dell.iehttp.IeHttp.StringUtils;
import com.zzti.fengyongge.imagepicker.PhotoSelectorActivity;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String url = "XXXXX";
    private Map<String,String> data = null;
    private Map<String, File> file_map = null;

    private Button select_img;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        select_img = findViewById(R.id.select_img);
        img = findViewById(R.id.img);

        select_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhotoSelectorActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("limit", 1 );//number是选择图片的数量
                startActivityForResult(intent, 0);
            }
        });


        data = new HashMap<>();
        data.put("upload_method","test");
//        sendRequest();
    }

    private void sendRequest(){
        LeHttp.sendJsonRequest(url, data,file_map,FileTestResponse.class, new LeJsonDataTransform<FileTestResponse>() {
            @Override
            public void onSuccess(FileTestResponse m) {
                Log.e("test", m.toString());
            }

            @Override
            public void onFailure() {
                Log.i("test","failure");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode) {
            case 0:
                if (data != null) {
                    List<String> paths = (List<String>) data.getExtras().getSerializable("photos");//path是选择拍照或者图片的地址数组
                    //处理代码
                    String path = paths.get(0);
                    Log.i("test",path);
                    String[] s = path.split("/");
                    Log.i("test",s[s.length-1]);
                    file_map = new HashMap<>();
                    file_map.put(s[s.length-1],new File(path));

                    BitmapFactory.Options options = new BitmapFactory.Options();

                    options.inPreferredConfig = Bitmap.Config.ARGB_4444;

                    sendRequest();
                    Bitmap bitmap = BitmapFactory.decodeFile(path,options);
                    img.setImageBitmap(bitmap);
                }
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
