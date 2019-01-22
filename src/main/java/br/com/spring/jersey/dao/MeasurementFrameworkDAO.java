package br.com.spring.jersey.dao;

import br.com.spring.jersey.dto.MeasurementFramework;

import java.util.Collection;

public interface MeasurementFrameworkDAO {

    Collection<MeasurementFramework> list();

    MeasurementFramework get(Integer idMeasurementFramework);

    Integer register(MeasurementFramework measurementFramework);

    Integer update(Integer idMeasurementFramework, MeasurementFramework measurementFramework);

    Integer delete(Integer idMeasurementFramework);
}
