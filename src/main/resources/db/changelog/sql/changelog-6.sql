--liquibase formatted sql
--changeset test:changelog-6.sql

    create sequence "shop_shop_id_seq";
    alter sequence "shop_shop_id_seq" owner to postgres;

    ALTER TABLE shop ALTER COLUMN id DROP IDENTITY IF EXISTS;
    alter table shop alter column id set not null;

    alter table shop alter column id set DEFAULT nextval('shop_shop_id_seq');
    select setval ('shop_shop_id_seq', (select max(id) from shop));
    alter sequence "shop_shop_id_seq" owned by shop.id;

