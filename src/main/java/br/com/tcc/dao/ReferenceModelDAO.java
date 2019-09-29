package br.com.tcc.dao;

import br.com.tcc.dto.ReferenceModel;

import java.util.Collection;

public interface ReferenceModelDAO {

    Collection<ReferenceModel> list();

    ReferenceModel get(Integer idReferenceModel);

    Integer register(ReferenceModel referenceModel);

    Integer update(Integer idReferenceModel, ReferenceModel referenceModel);

    Integer delete(Integer idReferenceModel);

    boolean isPossibleDelete(Integer idReferenceModel);
}
