package br.com.tcc.services;

import br.com.tcc.dto.ReferenceModel;

import java.util.Collection;

public interface ReferenceModelService {

    Collection<ReferenceModel> list();

    ReferenceModel get(Integer idReferenceModel);

    Integer register(ReferenceModel referenceModel);

    Integer update(Integer idReferenceModel, ReferenceModel referenceModel);

    Integer delete(Integer idReferenceModel);
}
