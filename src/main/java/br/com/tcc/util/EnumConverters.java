package br.com.tcc.util;

import br.com.tcc.dao.metadata.enums.EvaluationStatus;
import br.com.tcc.dto.Status;
import org.jooq.impl.EnumConverter;

public final class EnumConverters {

    private EnumConverters() {}

    public static final class MyEnumConverter extends EnumConverter<EvaluationStatus, Status> {
        public MyEnumConverter() {
            super(EvaluationStatus.class, Status.class);
        }
    }
}