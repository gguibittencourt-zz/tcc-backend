package br.com.tcc.util;

import br.com.tcc.dao.metadata.enums.AssessmentStatus;
import br.com.tcc.dto.Status;
import org.jooq.impl.EnumConverter;

public final class EnumConverters {

    private EnumConverters() {}

    public static final class MyEnumConverter extends EnumConverter<AssessmentStatus, Status> {
        public MyEnumConverter() {
            super(AssessmentStatus.class, Status.class);
        }
    }
}