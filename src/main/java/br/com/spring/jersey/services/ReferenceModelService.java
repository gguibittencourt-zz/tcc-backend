package br.com.spring.jersey.services;

import br.com.spring.jersey.dto.ReferenceModel;

import java.util.Collection;

public interface ReferenceModelService {

    Collection<ReferenceModel> list();

    ReferenceModel get(Integer idReferenceModel);

    Integer register(ReferenceModel referenceModel);
}
