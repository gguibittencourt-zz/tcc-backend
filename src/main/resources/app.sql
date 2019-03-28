CREATE database app;

use app;

CREATE TABLE company
(
  id_company      int PRIMARY KEY AUTO_INCREMENT,
  name            varchar(200)    default '',
  contributors    int             default 0,
  projects        int             default 0,
  occupation_area varchar(200)    default ''
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
  name               varchar(200) NOT NULL,
  knowledge_areas    json
);

CREATE TABLE measurement_framework
(
  id_measurement_framework   int PRIMARY KEY AUTO_INCREMENT,
  name                       varchar(200) NOT NULL,
  id_reference_model         int          not null,
  json_measurement_framework json,

  CONSTRAINT id_reference_model_measurement_framework_fk
  FOREIGN KEY (id_reference_model) REFERENCES reference_model (id_reference_model)
);

CREATE TABLE evaluation
(
  id_evaluation            int PRIMARY KEY AUTO_INCREMENT,
  date                     datetime NOT NULL,
  id_user                  int      not null,
  status                   varchar(30),
  id_measurement_framework int      not null,
  json_evaluation          json,

  CONSTRAINT id_measurement_framework_evaluation_fk
  FOREIGN KEY (id_measurement_framework) REFERENCES measurement_framework (id_measurement_framework),
  CONSTRAINT id_user_evaluation_fk
  FOREIGN KEY (id_user) REFERENCES user (id_user)
);
