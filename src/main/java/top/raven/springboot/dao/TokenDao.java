package top.raven.springboot.dao;

public class TokenDao {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenDao(String token) {
        this.token = token;
    }
}
