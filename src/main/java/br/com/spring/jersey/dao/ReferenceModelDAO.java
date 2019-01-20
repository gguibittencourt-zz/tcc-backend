package br.com.spring.jersey.dao;

import br.com.spring.jersey.dto.ReferenceModel;

import java.util.Collection;

public interface ReferenceModelDAO {

    Collection<ReferenceModel> list();

    ReferenceModel get(Integer idReferenceModel);

    Integer register(ReferenceModel referenceModel);

    Integer update(Integer idReferenceModel, ReferenceModel referenceModel);
}
