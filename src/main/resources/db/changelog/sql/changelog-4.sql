--liquibase formatted sql
--changeset test:changelog-4.sql

create sequence "sale_sale_id_seq";
alter sequence "sale_sale_id_seq" owner to postgres;

ALTER TABLE sale ALTER COLUMN id DROP IDENTITY IF EXISTS;
alter table sale alter column id set not null;

alter table sale alter column id set DEFAULT nextval('sale_sale_id_seq');
select setval ('sale_sale_id_seq', (select max(id) from sale));
alter sequence "sale_sale_id_seq" owned by sale.id;