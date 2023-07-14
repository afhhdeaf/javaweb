package top.raven.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.raven.springboot.controller.response.Response;
import top.raven.springboot.controller.response.ResponseCode;
import top.raven.springboot.exception.BusinessException;

@ControllerAdvice
public class ProjectExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Response doBusinessException(Exception exception){
        return new Response(ResponseCode.SYSTEM_ERR, exception.getMessage());
    }
}
