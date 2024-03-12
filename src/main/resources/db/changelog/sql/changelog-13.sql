--liquibase formatted sql
--changeset test:changelog-13.sql

create type user_role as enum ('CLIENT', 'ADMIN', 'COURIER');
alter type user_role owner to postgres;


create table users
(
  id bigint generated always as identity primary key,
  username  varchar(255) not null,
  password  varchar(255) not null,
  email varchar(255) not null,
  role user_role not null
);