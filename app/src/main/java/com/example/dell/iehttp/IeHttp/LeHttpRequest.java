package com.example.dell.iehttp.IeHttp;

public interface LeHttpRequest {

    void setUrl(String url);

    void setData(byte[] data);

    void setListener(CallbackListener callbackListener);

    void execute();

}
