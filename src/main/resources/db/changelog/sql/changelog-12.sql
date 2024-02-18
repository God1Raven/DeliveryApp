--liquibase formatted sql
--changeset test:changelog-12.sql

alter table sale drop column product_id;