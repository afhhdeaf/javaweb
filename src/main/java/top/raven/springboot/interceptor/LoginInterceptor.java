package top.raven.springboot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.raven.springboot.controller.response.Response;
import top.raven.springboot.controller.response.ResponseJson;
import top.raven.springboot.exception.SystemException;
import top.raven.springboot.service.redis.RedisService;
import top.raven.springboot.service.token.TokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws SystemException {
        String token = request.getHeader(tokenService.getTokenHeader()); // 获取token
        String method = request.getMethod();
        if ("OPTIONS".equals(method)){
            return true;
        }

        // 获取到了token, 则验证其合法性、是否和已缓存的token相等、是否过期
        if (token != null && !token.equals("")) {
            //用户使用的token和已缓存的token不相等
            if (!redisService.isCached(token)) {
                try {
                    write_msg(response);
                    return false;
                } catch (IOException exception) {
                    return false;
                }
            }

            //token是否过期
            if (!tokenService.isExpiration(token)) {
                return true;
            }

            else {  //token过期
                try {
                    write_msg(response);
                    return false;
                } catch (IOException exception) {
                    return false;
                }
            }
        }

        // 未获取到token, 返回403
        try {
            write_msg(response);
            return false;
        } catch (IOException exception) {
            return false;
        }
    }

    private void write_msg(HttpServletResponse response) throws IOException {
        Response res = new Response("", 403, "403 FORBIDDEN");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(ResponseJson.get(res).toJSONString());
        writer.flush();
        writer.close();
    }
}
