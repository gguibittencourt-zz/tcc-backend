package br.com.tcc.dto;

import java.util.Objects;

public class UpdateValue {

    private String config;
    private String valueConfig;
    private String valueResult;

    public String getConfig() {
        return config;
    }

    public UpdateValue setConfig(String config) {
        this.config = config;
        return this;
    }

    public String getValueConfig() {
        return valueConfig;
    }

    public UpdateValue setValueConfig(String valueConfig) {
        this.valueConfig = valueConfig;
        return this;
    }

    public String getValueResult() {
        return valueResult;
    }

    public UpdateValue setValueResult(String valueResult) {
        this.valueResult = valueResult;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateValue)) return false;
        UpdateValue that = (UpdateValue) o;
        return Objects.equals(getConfig(), that.getConfig()) &&
                Objects.equals(getValueConfig(), that.getValueConfig()) &&
                Objects.equals(getValueResult(), that.getValueResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConfig(), getValueConfig(), getValueResult());
    }
}
