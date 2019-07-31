package com.example.dell.iehttp.IeHttp;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class HttpTask<T> implements Runnable,Delayed {

    private LeHttpRequest leHttpRequest;

    public HttpTask(String url,T requestData,LeHttpRequest leHttpRequest,CallbackListener callbackListener){
        this.leHttpRequest = leHttpRequest;
        leHttpRequest.setUrl(url);
        leHttpRequest.setListener(callbackListener);
        String content = JSON.toJSONString(requestData);
        try {
            leHttpRequest.setData(content.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private long delayTime;
    private int retryCount;

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = System.currentTimeMillis() + delayTime;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public void run() {
        try {
            this.leHttpRequest.execute();
        }catch (Exception e){
            ThreadPoolManager.getInstance().addDelayTask(this);
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.delayTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS );
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
