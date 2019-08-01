package com.example.dell.iehttp;

public class FileTestResponse {


    /**
     * file : avatar/2.png
     * upload_method : 111
     * upload_time : 2019-08-01 05:57:09.400265+00:00
     */

    private String file;
    private String upload_method;
    private String upload_time;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUpload_method() {
        return upload_method;
    }

    public void setUpload_method(String upload_method) {
        this.upload_method = upload_method;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    @Override
    public String toString() {
        return "FileTestResponse{" +
                "file='" + file + '\'' +
                ", upload_method='" + upload_method + '\'' +
                ", upload_time='" + upload_time + '\'' +
                '}';
    }
}
