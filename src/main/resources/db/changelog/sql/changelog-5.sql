--liquibase formatted sql
--changeset test:changelog-4.sql

create sequence "shop_rating_shop_rating_id_seq";

alter sequence "shop_rating_shop_rating_id_seq" owner to postgres;

ALTER TABLE shop_rating ALTER COLUMN id DROP IDENTITY IF EXISTS;
alter table shop_rating alter column id set not null;

alter table shop_rating alter column id set DEFAULT nextval('shop_rating_shop_rating_id_seq');
select setval ('shop_rating_shop_rating_id_seq', (select max(id) from shop_rating));
alter sequence "shop_rating_shop_rating_id_seq" owned by shop_rating.id;