package com.huzhihui.flowable.utils;

/**
 * 消息状态
 *
 * @author JiangZhe  2018/4/12.
 */
public enum HttpCode {

    ERROR(0, "ERROR"),
    SUCCESS(1, "SUCCESS"),
    USER_PASSWORD_ERROR(-1, "用户名或密码错误"),
    UNKNOWN_ACCOUNT(-2, "用户名不存在"),
    INCORRECT_CREDENTIALS(-3, "密码错误"),
    LOGIN_FAILED(-4, "登录失败"),
    LOGOUT_ERROR(-5, "登出失败"),
    OVERTIME(-6, "登录超时"),
    TOKEN_INVALID(-7, "Token失效"),
    RANDOM_INVALID(-8, "随机数无效"),
    TOKEN_TIMEOUT_CODE(-9, "TOKEN_TIMEOUT"),
    NO_AUTH_CODE(-10, "非法访问"),
    NO_FOUND(-11, "未查询到数据"),
    DUPLICATE_DATA(-12, "重复数据"),
    OPERATE_EXPIRED(-13, "操作过期"),
    ;


    private final int code;

    private final String codeMessage;

    HttpCode(int code, String codeMessage) {
        this.code = code;
        this.codeMessage = codeMessage;
    }

    public int getCode() {
        return code;
    }

    public String getCodeMessage() {
        return codeMessage;
    }

    public static HttpCode getHttpCode(int i) {
        for(HttpCode q: HttpCode.values()) {
            if (q.code == i)
                return q;
        }
        throw new IllegalArgumentException("值无效: " + i);
    }
}
