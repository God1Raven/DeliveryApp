--liquibase formatted sql
--changeset test:changelog-10.sql

alter table sale drop constraint sale_product_id_fkey;