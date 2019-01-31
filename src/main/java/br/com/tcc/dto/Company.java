package br.com.tcc.dto;

public class Company {

    private Integer idCompany;
    private String name;
    private Integer contributors;
    private Integer projects;
    private String occupationArea;

    public Integer getIdCompany() {
        return idCompany;
    }

    public Company setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getContributors() {
        return contributors;
    }

    public Company setContributors(Integer contributors) {
        this.contributors = contributors;
        return this;
    }

    public Integer getProjects() {
        return projects;
    }

    public Company setProjects(Integer projects) {
        this.projects = projects;
        return this;
    }

    public String getOccupationArea() {
        return occupationArea;
    }

    public Company setOccupationArea(String occupationArea) {
        this.occupationArea = occupationArea;
        return this;
    }
}
