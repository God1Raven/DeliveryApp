--liquibase formatted sql
--changeset test:changelog-15.sql

ALTER TABLE users ALTER COLUMN id DROP IDENTITY IF EXISTS;
alter table users alter column id set not null;

alter table users alter column id set DEFAULT nextval('users_users_id_seq');
select setval ('users_users_id_seq', (select max(id) from users));
alter sequence "users_users_id_seq" owned by users.id;