package com.miaomiao.doufuwanzi.pojo;

import lombok.Data;

@Data
public class Result<T> {
    private static final int SUCCESS_CODE = 0; // 定义成功码
    private boolean success;
    private String message;
    private int code;
    private T data;

    public Result(boolean success, String message, int code, T data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static Result<String> success() {
        return new Result<>(true, null, SUCCESS_CODE, "success");
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, null, SUCCESS_CODE, data);
    }

    public static <T> Result<T> fail(String message, int code) {
        return new Result<>(false, message, code, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}

