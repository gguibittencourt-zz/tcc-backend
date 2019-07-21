package br.com.tcc.services.impl;

import br.com.tcc.dao.ReferenceModelDAO;
import br.com.tcc.dto.ReferenceModel;
import br.com.tcc.services.ReferenceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReferenceModelServiceImpl implements ReferenceModelService {

    private final ReferenceModelDAO referenceModelDAO;

    @Autowired
    public ReferenceModelServiceImpl(ReferenceModelDAO referenceModelDAO) {
        this.referenceModelDAO = referenceModelDAO;
    }

    @Override
    public Collection<ReferenceModel> list() {
         return this.referenceModelDAO.list();
    }

    @Override
    public ReferenceModel get(Integer idReferenceModel) {
        return this.referenceModelDAO.get(idReferenceModel);
    }

    @Override
    public Integer register(ReferenceModel referenceModel) {
        return this.referenceModelDAO.register(referenceModel);
    }

    @Override
    public Integer update(Integer idReferenceModel, ReferenceModel referenceModel) {
        return this.referenceModelDAO.update(idReferenceModel, referenceModel);
    }

    @Override
    public Integer delete(Integer idReferenceModel) {
        return this.referenceModelDAO.delete(idReferenceModel);
    }

}
