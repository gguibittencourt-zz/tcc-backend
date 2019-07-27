package br.com.tcc.dto;

import java.util.Collection;
import java.util.Objects;

public class MetricScale {

    private String idMetricScale;
    private String name;
    private Collection<MetricScale> values;
    private Collection<MetricScale> valueMetrics;

    public String getIdMetricScale() {
        return idMetricScale;
    }

    public MetricScale setIdMetricScale(String idMetricScale) {
        this.idMetricScale = idMetricScale;
        return this;
    }

    public String getName() {
        return name;
    }

    public MetricScale setName(String name) {
        this.name = name;
        return this;
    }

    public Collection<MetricScale> getValues() {
        return values;
    }

    public MetricScale setValues(Collection<MetricScale> values) {
        this.values = values;
        return this;
    }

    public Collection<MetricScale> getValueMetrics() {
        return valueMetrics;
    }

    public MetricScale setValueMetrics(Collection<MetricScale> valueMetrics) {
        this.valueMetrics = valueMetrics;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetricScale)) return false;
        MetricScale that = (MetricScale) o;
        return Objects.equals(getIdMetricScale(), that.getIdMetricScale()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getValues(), that.getValues()) &&
                Objects.equals(getValueMetrics(), that.getValueMetrics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMetricScale(), getName(), getValues(), getValueMetrics());
    }
}
