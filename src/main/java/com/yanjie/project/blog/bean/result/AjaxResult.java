package com.yanjie.project.blog.bean.result;

/**
 * Description: AjaxResult
 * Author: wangjie12
 * Create: 2015-07-19
 */
public class AjaxResult<T> {
    private String message;
    private Integer status;
    private boolean success;
    private T data;

    public AjaxResult() {

    }

    public AjaxResult(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public AjaxResult(boolean success, T data) {
        this.success = success;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
