--liquibase formatted sql
--changeset test:changelog-14.sql

create sequence "users_users_id_seq";

alter sequence "users_users_id_seq" owner to postgres;

alter table users owner to postgres;

alter sequence "users_users_id_seq" owned by users.id;