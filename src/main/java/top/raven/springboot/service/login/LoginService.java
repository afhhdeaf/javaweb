package top.raven.springboot.service.login;

public interface LoginService {
    String login(String username, String password);  //登陆成功返回token, 失败返回空串
    boolean logout(String token);
}
