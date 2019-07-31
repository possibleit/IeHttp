package com.example.dell.iehttp.IeHttp;

public interface LeJsonDataTransform<T> {

    void onSuccess(T m);

    void onFailure();

}
