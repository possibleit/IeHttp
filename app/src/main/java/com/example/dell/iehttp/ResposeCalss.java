package com.example.dell.iehttp;

public class ResposeCalss {

    /**
     * model : file.upload_file
     * pk : 1
     * fields : {"file":"avatar/1_jnvsQWD.jpg","upload_method":"111","upload_time":"2019-07-29T08:41:53.845Z"}
     */

    private String model;
    private int pk;
    private FieldsBean fields;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public FieldsBean getFields() {
        return fields;
    }

    public void setFields(FieldsBean fields) {
        this.fields = fields;
    }

    public static class FieldsBean {
        /**
         * file : avatar/1_jnvsQWD.jpg
         * upload_method : 111
         * upload_time : 2019-07-29T08:41:53.845Z
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
    }
}
