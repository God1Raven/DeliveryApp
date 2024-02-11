--liquibase formatted sql
--changeset test:changelog-2.sql
create sequence "client_client_id_seq";
alter sequence "client_client_id_seq" owner to postgres;

ALTER TABLE client ALTER COLUMN id DROP IDENTITY IF EXISTS;
alter table client alter column id set not null;

alter table client alter column id set DEFAULT nextval('client_client_id_seq');
select setval ('client_client_id_seq', (select max(id) from client));
alter sequence "client_client_id_seq" owned by client.id;

drop sequence "User_User_Id_seq";