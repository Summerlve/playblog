# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  id                        bigint auto_increment not null,
  title                     varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  tag_id                    bigint,
  content                   longtext,
  create_by                 bigint not null,
  create_at                 datetime(6),
  update_by                 bigint not null,
  update_at                 datetime(6),
  constraint uq_article_title unique (title),
  constraint pk_article primary key (id))
;

create table item (
  id                        bigint auto_increment not null,
  description               varchar(255),
  constraint pk_item primary key (id))
;

create table object (
  id                        bigint auto_increment not null,
  description               varchar(255),
  constraint pk_object primary key (id))
;

create table operation (
  id                        bigint auto_increment not null,
  name                      varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  description               varchar(255),
  constraint uq_operation_name unique (name),
  constraint pk_operation primary key (id))
;

create table part (
  id                        bigint auto_increment not null,
  description               varchar(255),
  constraint pk_part primary key (id))
;

create table permission (
  id                        bigint auto_increment not null,
  name                      varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  operation_id              bigint not null,
  sub_object_id             bigint not null,
  description               varchar(255),
  constraint uq_permission_name unique (name),
  constraint pk_permission primary key (id))
;

create table role (
  id                        bigint auto_increment not null,
  name                      varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  description               varchar(255),
  constraint uq_role_name unique (name),
  constraint pk_role primary key (id))
;

create table star (
  id                        bigint auto_increment not null,
  star_to                   bigint not null,
  star_by_ip                varchar(255),
  star_at                   datetime(6),
  constraint pk_star primary key (id))
;

create table sub_object (
  id                        bigint auto_increment not null,
  name                      varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  object_id                 bigint not null,
  item_id                   bigint not null,
  part_id                   bigint not null,
  description               varchar(255),
  constraint uq_sub_object_name unique (name),
  constraint pk_sub_object primary key (id))
;

create table tag (
  id                        bigint auto_increment not null,
  name                      varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  create_by                 bigint,
  create_at                 datetime(6),
  update_by                 bigint,
  update_at                 datetime(6),
  constraint uq_tag_name unique (name),
  constraint pk_tag primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  password_hash             varchar(255) not null,
  pen_name                  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin not null,
  avatar                    varchar(255),
  introduce                 varchar(255),
  constraint uq_user_username unique (username),
  constraint uq_user_pen_name unique (pen_name),
  constraint pk_user primary key (id))
;


create table role_permission (
  role_id                        bigint not null,
  permission_id                  bigint not null,
  constraint pk_role_permission primary key (role_id, permission_id))
;

create table user_role (
  user_id                        bigint not null,
  role_id                        bigint not null,
  constraint pk_user_role primary key (user_id, role_id))
;
alter table article add constraint fk_article_tag_1 foreign key (tag_id) references tag (id) on delete restrict on update restrict;
create index ix_article_tag_1 on article (tag_id);
alter table article add constraint fk_article_creater_2 foreign key (create_by) references user (id) on delete restrict on update restrict;
create index ix_article_creater_2 on article (create_by);
alter table article add constraint fk_article_updater_3 foreign key (update_by) references user (id) on delete restrict on update restrict;
create index ix_article_updater_3 on article (update_by);
alter table permission add constraint fk_permission_operation_4 foreign key (operation_id) references operation (id) on delete restrict on update restrict;
create index ix_permission_operation_4 on permission (operation_id);
alter table permission add constraint fk_permission_subObject_5 foreign key (sub_object_id) references sub_object (id) on delete restrict on update restrict;
create index ix_permission_subObject_5 on permission (sub_object_id);
alter table star add constraint fk_star_article_6 foreign key (star_to) references article (id) on delete restrict on update restrict;
create index ix_star_article_6 on star (star_to);
alter table sub_object add constraint fk_sub_object_object_7 foreign key (object_id) references object (id) on delete restrict on update restrict;
create index ix_sub_object_object_7 on sub_object (object_id);
alter table sub_object add constraint fk_sub_object_item_8 foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_sub_object_item_8 on sub_object (item_id);
alter table sub_object add constraint fk_sub_object_part_9 foreign key (part_id) references part (id) on delete restrict on update restrict;
create index ix_sub_object_part_9 on sub_object (part_id);
alter table tag add constraint fk_tag_creater_10 foreign key (create_by) references user (id) on delete restrict on update restrict;
create index ix_tag_creater_10 on tag (create_by);
alter table tag add constraint fk_tag_updater_11 foreign key (update_by) references user (id) on delete restrict on update restrict;
create index ix_tag_updater_11 on tag (update_by);



alter table role_permission add constraint fk_role_permission_role_01 foreign key (role_id) references role (id) on delete restrict on update restrict;

alter table role_permission add constraint fk_role_permission_permission_02 foreign key (permission_id) references permission (id) on delete restrict on update restrict;

alter table user_role add constraint fk_user_role_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_role add constraint fk_user_role_role_02 foreign key (role_id) references role (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table article;

drop table item;

drop table object;

drop table operation;

drop table part;

drop table permission;

drop table role_permission;

drop table role;

drop table user_role;

drop table star;

drop table sub_object;

drop table tag;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

