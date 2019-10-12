package br.com.tcc.dto;

import java.util.Objects;

public class DataSource {

    private Integer idDataSource;
    private Integer idCompany;
    private String name;
    private String url;
    private String authenticated;
    private String user;
    private String password;

    public Integer getIdDataSource() {
        return idDataSource;
    }

    public DataSource setIdDataSource(Integer idDataSource) {
        this.idDataSource = idDataSource;
        return this;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public DataSource setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
        return this;
    }

    public String getName() {
        return name;
    }

    public DataSource setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DataSource setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getAuthenticated() {
        return authenticated;
    }

    public DataSource setAuthenticated(String authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public String getUser() {
        return user;
    }

    public DataSource setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataSource setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataSource)) return false;
        DataSource that = (DataSource) o;
        return Objects.equals(getIdDataSource(), that.getIdDataSource()) &&
                Objects.equals(getIdCompany(), that.getIdCompany()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getAuthenticated(), that.getAuthenticated()) &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDataSource(), getIdCompany(), getName(), getUrl(), getAuthenticated(), getUser(), getPassword());
    }
}
