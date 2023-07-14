package top.raven.springboot.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.raven.springboot.mapper.LoginMapper;
import top.raven.springboot.service.redis.RedisService;
import top.raven.springboot.service.token.TokenService;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisService redisService;

    @Override
    public String login(String username, String password) {
        Integer sqlResult = loginMapper.login(username, password);
        String token = "";
        if (sqlResult != null) {
            token = tokenService.creatToken(username);
            redisService.setCache(username, token);
        }
        return token;
    }

    @Override
    public boolean logout(String token) {
        String username = tokenService.getUsername(token);
        System.out.println(username);
        if (username != null) {
            if (!username.equals("")) redisService.setCache(username, "01");
            return true;
        }
        return false;
    }
}
