--liquibase formatted sql
--changeset test:changelog-9.sql

ALTER TABLE order_product DROP COLUMN id;

alter table sale add column product_id bigint;
