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

CREATE TABLE process
(
  id_process int PRIMARY KEY AUTO_INCREMENT,
  name       varchar(200) NOT NULL,
  purpose    varchar(255)
);

CREATE TABLE knowledge_area
(
  id_knowledge_area   int PRIMARY KEY AUTO_INCREMENT,
  name                varchar(200) NOT NULL,
  purpose             varchar(200),
  json_knowledge_area json
);

CREATE TABLE re_process_knowledge_area
(
  id_process        int not null,
  id_knowledge_area int not null,
  primary key (id_process, id_knowledge_area),
  CONSTRAINT re_process_knowledge_area_id_process_fk
  FOREIGN KEY (id_process) REFERENCES process (id_process),
  CONSTRAINT re_process_knowledge_area_id_knowledge_area_fk
  FOREIGN KEY (id_knowledge_area) REFERENCES knowledge_area (id_knowledge_area)
);

CREATE TABLE reference_model
(
  id_reference_model   int PRIMARY KEY AUTO_INCREMENT,
  name                 varchar(200) NOT NULL,
  json_reference_model json
);

CREATE TABLE re_knowledge_area_reference_model
(
  id_knowledge_area  int not null,
  id_reference_model int not null,
  primary key (id_knowledge_area, id_reference_model),
  CONSTRAINT re_knowledge_area_reference_model_id_reference_model_fk
  FOREIGN KEY (id_reference_model) REFERENCES reference_model (id_reference_model),
  CONSTRAINT re_knowledge_area_reference_model_id_knowledge_area_fk
  FOREIGN KEY (id_knowledge_area) REFERENCES knowledge_area (id_knowledge_area)
);