package com.miaomiao.doufuwanzi.enums;

public enum ErrorCode {
    /**
     * 返回code约定，成功为0
     * 其他错误的尽量按照前三位为httpStatus，后两位为自定义的方式
     */
    SUCCESS(0, "成功"),
    BAD_REQUEST(400, "请求错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到资源"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_GATEWAY(502, "网关错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),

    //  参数错误码示例
    PARAMETER_ERROR(40000, "参数错误"),
    DATA_INTEGRITY_VIOLATION(40000, "数据完整性验证失败"),

    // 业务错误码示例
    USER_NOT_FOUND(40001, "用户未找到"),
    USER_ALREADY_EXIST(40002, "用户已存在"),
    USER_PASSWORD_ERROR(40003, "密码错误"),
    USER_LOGIN_FAILED(40004, "登录失败"),
    USER_NOT_LOGIN(40005, "用户未登录"),
    USER_NOT_ACTIVE(40006, "用户未激活"),

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

