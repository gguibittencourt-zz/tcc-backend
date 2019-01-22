package br.com.spring.jersey.services;

import br.com.spring.jersey.dto.MeasurementFramework;

import java.util.Collection;

public interface MeasurementFrameworkService {

    Collection<MeasurementFramework> list();

    MeasurementFramework get(Integer idMeasurementFramework);

    Integer register(MeasurementFramework referenceModel);

    Integer update(Integer idMeasurementFramework, MeasurementFramework referenceModel);

    Integer delete(Integer idMeasurementFramework);
}
