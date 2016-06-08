package com.doctor.common;

import java.util.Objects;

/**
 * Created by lzc on 2016/5/12.
 */
public class Result<T> {
    private T data;
    private Boolean success;
    private String message;
    private Integer status;

    public Result(){}

    public Result(T data, Boolean success, String message, Integer status){
        this.data = data;
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public static Result buildSuccessResult(Object data){
        Result result = new Result();
        result.success = true;
        result.status = 200;
        result.message = "success";
        result.data = data;
        return  result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
