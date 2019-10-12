package br.com.tcc.dto;

import java.util.Objects;

public class DataSourceQuestion {

    private Integer idDataSource;
    private String path;
    private String typeReturn;
    private String valueReturn;

    public Integer getIdDataSource() {
        return idDataSource;
    }

    public DataSourceQuestion setIdDataSource(Integer idDataSource) {
        this.idDataSource = idDataSource;
        return this;
    }

    public String getPath() {
        return path;
    }

    public DataSourceQuestion setPath(String path) {
        this.path = path;
        return this;
    }

    public String getTypeReturn() {
        return typeReturn;
    }

    public DataSourceQuestion setTypeReturn(String typeReturn) {
        this.typeReturn = typeReturn;
        return this;
    }

    public String getValueReturn() {
        return valueReturn;
    }

    public DataSourceQuestion setValueReturn(String valueReturn) {
        this.valueReturn = valueReturn;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataSourceQuestion)) return false;
        DataSourceQuestion that = (DataSourceQuestion) o;
        return Objects.equals(getIdDataSource(), that.getIdDataSource()) &&
                Objects.equals(getPath(), that.getPath()) &&
                Objects.equals(getTypeReturn(), that.getTypeReturn()) &&
                Objects.equals(getValueReturn(), that.getValueReturn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDataSource(), getPath(), getTypeReturn(), getValueReturn());
    }
}
