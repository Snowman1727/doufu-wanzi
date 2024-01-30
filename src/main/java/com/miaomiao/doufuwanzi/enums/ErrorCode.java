package com.miaomiao.doufuwanzi.enums;

public enum ErrorCode {
    /**
     * 返回code约定，成功为0
     * 其他错误的尽量按照前三位为httpStatus，后两位为自定义的方式
     */
    SUCCESS(0, "成功"),

    SYSTEM_ERROR(500, "系统错误"),

    // 自定义错误码示例
    INVALID_PARAMETER(40001, "无效参数"),
    PERMISSION_DENIED(40301, "权限不足"),
    NOT_FOUND(40401, "资源未找到"),
    DUPLICATE_ENTRY(40901, "重复记录"),
    INTERNAL_SERVER_ERROR(50001, "内部服务器错误"),

    ;

    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

