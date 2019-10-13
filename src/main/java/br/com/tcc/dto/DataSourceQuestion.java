package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class DataSourceQuestion {

    private DataSource dataSource;
    private String path;
    private String typeReturn;
    private String valueReturn;
    private Collection<UpdateValue> updateValues;

    public DataSource getDataSource() {
        return dataSource;
    }

    public DataSourceQuestion setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
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

    public Collection<UpdateValue> getUpdateValues() {
        return updateValues;
    }

    public DataSourceQuestion setUpdateValues(Collection<UpdateValue> updateValues) {
        this.updateValues = updateValues;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataSourceQuestion)) return false;
        DataSourceQuestion that = (DataSourceQuestion) o;
        return Objects.equals(getDataSource(), that.getDataSource()) &&
                Objects.equals(getPath(), that.getPath()) &&
                Objects.equals(getTypeReturn(), that.getTypeReturn()) &&
                Objects.equals(getValueReturn(), that.getValueReturn()) &&
                Objects.equals(getUpdateValues(), that.getUpdateValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataSource(), getPath(), getTypeReturn(), getValueReturn(), getUpdateValues());
    }
}
