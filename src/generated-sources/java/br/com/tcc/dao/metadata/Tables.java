/*
 * This file is generated by jOOQ.
*/
package br.com.tcc.dao.metadata;


import br.com.tcc.dao.metadata.tables.Company;
import br.com.tcc.dao.metadata.tables.Evaluation;
import br.com.tcc.dao.metadata.tables.MeasurementFramework;
import br.com.tcc.dao.metadata.tables.ReferenceModel;
import br.com.tcc.dao.metadata.tables.User;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in app
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>app.company</code>.
     */
    public static final Company COMPANY = br.com.tcc.dao.metadata.tables.Company.COMPANY;

    /**
     * The table <code>app.evaluation</code>.
     */
    public static final Evaluation EVALUATION = br.com.tcc.dao.metadata.tables.Evaluation.EVALUATION;

    /**
     * The table <code>app.measurement_framework</code>.
     */
    public static final MeasurementFramework MEASUREMENT_FRAMEWORK = br.com.tcc.dao.metadata.tables.MeasurementFramework.MEASUREMENT_FRAMEWORK;

    /**
     * The table <code>app.reference_model</code>.
     */
    public static final ReferenceModel REFERENCE_MODEL = br.com.tcc.dao.metadata.tables.ReferenceModel.REFERENCE_MODEL;

    /**
     * The table <code>app.user</code>.
     */
    public static final User USER = br.com.tcc.dao.metadata.tables.User.USER;
}
