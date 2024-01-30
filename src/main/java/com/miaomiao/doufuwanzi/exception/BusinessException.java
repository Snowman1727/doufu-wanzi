package com.miaomiao.doufuwanzi.exception;

import com.miaomiao.doufuwanzi.enums.ErrorCode;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常信息
     */
    protected String message;

    /**
     * 具体异常码
     */
    protected int code;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getCode() + ":" + errorCode.getMsg());
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public BusinessException(int code, String message) {
        super(code + ":" + message);
        this.code = code;
        this.message = message;
    }

    private BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.message = String.format(msgFormat, args);
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
        this.code = ErrorCode.SYSTEM_ERROR.getCode();
    }

    public BusinessException(ErrorCode errorCode, Object... args) {
        super(String.format("%d:%s", errorCode.getCode(), String.format(errorCode.getMsg(), args)));
        this.code = errorCode.getCode();
        this.message = String.format(errorCode.getMsg(), args);
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}

