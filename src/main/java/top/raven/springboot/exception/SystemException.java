package top.raven.springboot.exception;


/*
2.系统异常(SystemException)
    - 项目运行中可以预计但无法避免的异常
    => 处理方案
        --> 发送固定消息给用户，安抚用户
        --> 发送消息给运维人员，提醒维护
        --> 记录日志
 */
public class SystemException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}