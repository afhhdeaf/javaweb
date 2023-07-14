package top.raven.springboot.service.token;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Service;
import top.raven.springboot.exception.BusinessException;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService{
    private static final String TOKEN_HEADER = "token";

    @Override
    public String getTokenHeader() {
        return TOKEN_HEADER;
    }

    //KEY
    private static final String secret_str = "4rpehh3guWROWZ3rWSkGINPw6iKAIL2lgfE6s8f7zwDz1VKZ9e" +
           "HaY6JUJJXCvDsITxNP2jmIQZp8D7Q4GtNuWZpqI5zptwdi07Z5" +
            "RU1ylM7gNlxrkdVginMnhS2SO5ZsCnusFRO2SAbQilJhOPTde7RSiX8skr1Xb" +
            "o6X8qNw3lUifUgtbS3oeUIBvE1Q6nTGFfQvz8uBk3em30KlgV9vZ9opujgNQPV5GKFb" +
            "250akgvxvgsQjRHNLRQdIvMHMmLblrHYc3pLm1vM8X9QKu";

    private static final byte[] SECRET = secret_str.getBytes(StandardCharsets.UTF_8);

    //JWT的发行人
    private static final String ISS = "Raven Stock";

    //过期时间是3600秒，既是1个小时
    public static final long EXPIRATION = 10L * 1000;
//    public static final long EXPIRATION = 3600L * 1000;

    //选择了记住我之后的过期时间为7天
    public static final long EXPIRATION_REMEMBER = 604800L * 1000;


    // 生成TOKEN
    @Override
    public String creatToken(String username){
        return Jwts.builder().signWith(Keys.hmacShaKeyFor(SECRET), SignatureAlgorithm.HS256)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    // 从TOKEN获取用户名
    @Override
    public String getUsername(String token)  {
        try {
            return getTokenBody(token).getSubject();
        } catch (SignatureException exception) {
            BusinessException e = new BusinessException(500, "非法token", exception.getCause());
            throw e;
        }
    }

    //是否已过期
    @Override
    public boolean isExpiration(String token) {
        try {
            Claims claim = getTokenBody(token);
            Date expiration = claim.getExpiration();
            Date current = new Date(System.currentTimeMillis());
            return expiration.before(current);
        } catch (SignatureException exception) {
            BusinessException e = new BusinessException(500, "非法token", exception.getCause());
            throw e;
        }
    }

    private static Claims getTokenBody(String token) throws SignatureException {
        Claims claims;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

    @Override
    public Long getExpiration() {
        return EXPIRATION;
    }
}
