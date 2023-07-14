package top.raven.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.raven.springboot.controller.response.Response;
import top.raven.springboot.controller.response.ResponseCode;
import top.raven.springboot.dao.TokenDao;
import top.raven.springboot.dao.UserDao;
import top.raven.springboot.service.login.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public Response login(@RequestBody UserDao userDao){
        String token = loginService.login(userDao.getUsername(), userDao.getPassword());
        boolean flag = !token.equals("");  //token为空，表示登陆失败
        String msg = flag ? "OK": "FAIlED";
        return new Response(new TokenDao(token), flag ? ResponseCode.LOGIN_OK : ResponseCode.LOGIN_ERR, msg);
    }

    @PostMapping("/logout")
    @ResponseBody
    public Response logout(@RequestHeader("token") String token) {
        boolean flag = loginService.logout(token);
        return new Response(flag ? ResponseCode.LOGOUT_OK: ResponseCode.LOGOUT_ERR);
    }
}
