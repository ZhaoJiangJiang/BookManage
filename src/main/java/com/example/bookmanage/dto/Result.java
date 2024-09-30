package com.example.bookmanage.dto;

/**
 * 封装JSON对象 所有返回结果都使用它
 * @param <T>
 */
public class Result<T> {
    private boolean success;
    private T data;
    private String error;

    // error时的构造器
    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    // 成功时的构造器
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError(String error) {
        this.error = error;
    }
}




















