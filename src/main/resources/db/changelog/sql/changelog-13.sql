--liquibase formatted sql
--changeset test:changelog-13.sql

alter table admin alter column id  type bigint;