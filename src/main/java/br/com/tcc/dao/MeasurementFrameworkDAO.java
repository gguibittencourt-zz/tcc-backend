package br.com.tcc.dao;

import br.com.tcc.dto.MeasurementFramework;

import java.util.Collection;

public interface MeasurementFrameworkDAO {

    Collection<MeasurementFramework> list();

    MeasurementFramework get(Integer idMeasurementFramework);

    Integer register(MeasurementFramework measurementFramework);

    Integer update(Integer idMeasurementFramework, MeasurementFramework measurementFramework);

    Integer delete(Integer idMeasurementFramework);

    Collection<MeasurementFramework> listByIds(Collection<Integer> idsMeasurementFramework);
}
