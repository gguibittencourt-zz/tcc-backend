package br.com.tcc.services;

import br.com.tcc.dto.MeasurementFramework;

import java.util.Collection;

public interface MeasurementFrameworkService {

    Collection<MeasurementFramework> list();

    MeasurementFramework get(Integer idMeasurementFramework);

    Integer register(MeasurementFramework referenceModel);

    Integer update(Integer idMeasurementFramework, MeasurementFramework referenceModel);

    Integer delete(Integer idMeasurementFramework);
}
