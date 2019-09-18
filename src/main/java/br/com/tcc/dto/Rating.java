package br.com.tcc.dto;

import java.util.Objects;

public class Rating {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public Rating setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Rating setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating that = (Rating) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
