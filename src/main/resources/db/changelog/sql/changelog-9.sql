--liquibase formatted sql
--changeset test:changelog-9.sql

ALTER TABLE order_product DROP COLUMN id;

