# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table role (
  id                        bigint(20) auto_increment not null,
  name                      varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  constraint uq_role_name unique (name),
  constraint pk_role primary key (id))
;

create table user (
  id                        bigint(20) auto_increment not null,
  username                  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  password_hash             varchar(255) not null,
  pen_name                  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  avatar                    varchar(255),
  introduce                 varchar(255),
  constraint uq_user_username unique (username),
  constraint uq_user_pen_name unique (pen_name),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table role;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

