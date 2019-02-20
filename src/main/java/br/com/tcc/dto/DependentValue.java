package br.com.tcc.dto;

public class DependentValue {

    private String id;
    private String title;
    private Object value;

    public String getId() {
        return id;
    }

    public DependentValue setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DependentValue setTitle(String title) {
        this.title = title;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public DependentValue setValue(Object value) {
        this.value = value;
        return this;
    }
}
