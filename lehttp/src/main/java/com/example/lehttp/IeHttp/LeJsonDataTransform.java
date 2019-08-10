package com.example.lehttp.IeHttp;

public interface LeJsonDataTransform<T> {

    void onSuccess(T m);

    void onFailure();

}
