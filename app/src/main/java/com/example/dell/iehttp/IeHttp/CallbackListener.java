package com.example.dell.iehttp.IeHttp;

import java.io.InputStream;

public interface CallbackListener {

    void onSuccess(InputStream inputStream);

    void onFailure();

}
