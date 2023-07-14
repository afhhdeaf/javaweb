package top.raven.springboot.controller.response;

public class ResponseCode {
    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;

    public static final Integer SYSTEM_ERR = 50001;
    public static final Integer BUSINESS_ERR = 50002;

    public static final Integer LOGIN_OK = 60010;
    public static final Integer LOGIN_ERR = 60011;

    public static final Integer LOGOUT_OK = 70010;
    public static final Integer LOGOUT_ERR = 70011;
}
