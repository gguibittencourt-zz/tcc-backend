package br.com.spring.jersey.dto;

public class User {

    private Integer idUser;
    private String username;
    private String name;
    private String password;
    private Integer idCompany;

    public User(Integer idUser, String username, String name, String password, Integer idCompany) {
        this.idUser = idUser;
        this.username = username;
        this.name = name;
        this.password = password;
        this.idCompany = idCompany;
    }

    public User(User user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.name = user.getName();
        this.password = user.getPassword();
        this.idCompany = user.getIdCompany();
    }

    public Integer getIdUser() {
        return idUser;
    }

    public User setIdUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public User setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
        return this;
    }

    public byte[] getBytesUsernameAndPassword() {
        return this.getUsername().concat(this.getPassword()).getBytes();
    }
}
