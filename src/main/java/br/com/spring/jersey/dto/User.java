package br.com.spring.jersey.dto;

public class User {

    private Integer idUser;
    private String username;
    private String name;
    private String password;

    public User(Integer idUser, String username, String name, String password) {
        this.idUser = idUser;
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public User(User user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.name = user.getName();
        this.password = user.getPassword();
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getBytesUsernameAndPassword() {
        return this.getUsername().concat(this.getPassword()).getBytes();
    }
}
