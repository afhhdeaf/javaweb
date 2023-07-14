package top.raven.springboot.service.token;

public interface TokenService {
    String creatToken(String username);  // 生成TOKEN
    String getUsername(String token);    // 从TOKEN获取用户名
    boolean isExpiration(String token);  //是否已过期
    Long getExpiration();
    String getTokenHeader();
}
