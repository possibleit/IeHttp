package com.example.lehttp.IeHttp;

import java.io.InputStream;

public interface CallbackListener {

    void onSuccess(InputStream inputStream);

    void onFailure();

}
