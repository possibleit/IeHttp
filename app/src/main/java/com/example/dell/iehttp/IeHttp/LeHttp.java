package com.example.dell.iehttp.IeHttp;

import java.util.concurrent.ThreadPoolExecutor;

public class LeHttp {

    public static<T,M> void sendJsonRequest(String url,T requestData,Class<M> response,LeJsonDataTransform listener){

        LeHttpRequest leHttpRequest = new JsonHttpRequest();
        CallbackListener callbackListener = new JsonCallbackListener<>(response,listener);

        HttpTask httpTask = new HttpTask(url,requestData,leHttpRequest,callbackListener);

        ThreadPoolManager.getInstance().addTask(httpTask);
    }
}
