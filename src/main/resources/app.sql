CREATE database app;

use app;

CREATE TABLE company
(
    id_company      int PRIMARY KEY AUTO_INCREMENT,
    name            varchar(200) default '',
    contributors    int          default 0,
    projects        int          default 0,
    occupation_area varchar(200) default ''
);

CREATE TABLE user
(
    id_user    int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username   varchar(100)    NOT NULL,
    name       varchar(200)    NOT NULL,
    password   varchar(100)    NOT NULL,
    id_company int             NOT NULL,
    role       varchar(5)      NOT NULL,

    CONSTRAINT user_id_company_fk
        FOREIGN KEY (id_company) REFERENCES company (id_company)
);

CREATE UNIQUE INDEX user_username_uindex
    ON user (username);

CREATE TABLE reference_model
(
    id_reference_model int PRIMARY KEY AUTO_INCREMENT,
    name               varchar(200) NOT NULL UNIQUE,
    knowledge_areas    json
);

CREATE TABLE measurement_framework
(
    id_measurement_framework   int PRIMARY KEY AUTO_INCREMENT,
    name                       varchar(200) NOT NULL UNIQUE,
    type                       varchar(200) NOT NULL,
    id_reference_model         int          not null,
    json_measurement_framework json,

    CONSTRAINT id_reference_model_measurement_framework_fk
        FOREIGN KEY (id_reference_model) REFERENCES reference_model (id_reference_model)
);

CREATE TABLE assessment
(
    id_assessment   int PRIMARY KEY AUTO_INCREMENT,
    date            datetime NOT NULL,
    id_user         int      not null,
    status          ENUM ('in_progress', 'finalized'),
    json_assessment json,
    CONSTRAINT id_user_assessment_fk
        FOREIGN KEY (id_user) REFERENCES user (id_user)
);

CREATE TABLE data_source
(
    id_data_source int PRIMARY KEY AUTO_INCREMENT,
    id_company        int not null,
    name           varchar(200),
    url            varchar(255),
    authenticated  char(1),
    user           varchar(200),
    password       varchar(200),
    CONSTRAINT id_company_data_source_fk
        FOREIGN KEY (id_company) REFERENCES user (id_company)
);