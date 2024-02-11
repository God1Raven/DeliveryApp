--liquibase formatted sql
--changeset test:changelog-3.sql
create sequence "product_product_id_seq";
alter sequence "product_product_id_seq" owner to postgres;

ALTER TABLE product ALTER COLUMN id DROP IDENTITY IF EXISTS;
alter table product alter column id set not null;

alter table product alter column id set DEFAULT nextval('product_product_id_seq');
select setval ('product_product_id_seq', (select max(id) from product));
alter sequence "product_product_id_seq" owned by product.id;
--liquibase formatted sql
--changeset test:changelog-4.sql

--     create sequence "shop_shop_id_seq";
--     alter sequence "shop_shop_id_seq" owner to postgres;
--
--     ALTER TABLE product ALTER COLUMN id DROP IDENTITY IF EXISTS;
--     alter table product alter column id set not null;
--
--     alter table shop alter column id set DEFAULT nextval('shop_shop_id_seq');
--     select setval ('shop_shop_id_seq', (select max(id) from shop));
--     alter sequence "shop_shop_id_seq" owned by shop.id;

