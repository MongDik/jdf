/* 
 * @(#)DataResponse.java    Created on 2014-7-29
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.utils;

public class DataResponse {

    private boolean success;
    private Object data;
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    
    
}
