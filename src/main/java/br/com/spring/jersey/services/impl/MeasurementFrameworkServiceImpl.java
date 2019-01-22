package br.com.spring.jersey.services.impl;

import br.com.spring.jersey.dao.MeasurementFrameworkDAO;
import br.com.spring.jersey.dto.MeasurementFramework;
import br.com.spring.jersey.services.MeasurementFrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MeasurementFrameworkServiceImpl implements MeasurementFrameworkService {

    private final MeasurementFrameworkDAO measurementFrameworkDAO;

    @Autowired
    public MeasurementFrameworkServiceImpl(MeasurementFrameworkDAO measurementFrameworkDAO) {
        this.measurementFrameworkDAO = measurementFrameworkDAO;
    }

    @Override
    public Collection<MeasurementFramework> list() {
        return this.measurementFrameworkDAO.list();
    }

    @Override
    public MeasurementFramework get(Integer idMeasurementFramework) {
        return this.measurementFrameworkDAO.get(idMeasurementFramework);
    }

    @Override
    public Integer register(MeasurementFramework measurementFramework) {
        return this.measurementFrameworkDAO.register(measurementFramework);
    }

    @Override
    public Integer update(Integer idMeasurementFramework, MeasurementFramework measurementFramework) {
        return this.measurementFrameworkDAO.update(idMeasurementFramework, measurementFramework);
    }

    @Override
    public Integer delete(Integer idMeasurementFramework) {
        return this.measurementFrameworkDAO.delete(idMeasurementFramework);
    }

}
