package top.raven.springboot.exception;

/*
 1.业务异常(BusinessException)
         - 规范的用户行为产生的异常
         - 不规范的用户行为产生的异常
         => 处理方案
         --> 发送固定消息给用户，提醒规范操作
*/
public class BusinessException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
