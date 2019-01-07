CREATE SCHEMA public;

CREATE TABLE user
(
    id_user int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username varchar(100) NOT NULL,
    name varchar(200) NOT NULL,
    password varchar(100) NOT NULL
);
CREATE UNIQUE INDEX user_username_uindex ON user (username);