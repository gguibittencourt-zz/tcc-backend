package br.com.spring.jersey.dto;

public class UserLogin extends User {

    private String token;

    public UserLogin(User user) {
        super(user);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
