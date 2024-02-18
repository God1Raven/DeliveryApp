--liquibase formatted sql
--changeset test:changelog-8.sql

alter table sale DROP CONSTRAINT courier_fkey;
alter table sale add constraint courier_fkey FOREIGN KEY (courier_id) REFERENCES courier(id) ON DELETE SET NULL;