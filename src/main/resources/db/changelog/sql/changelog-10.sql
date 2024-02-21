--liquibase formatted sql
--changeset test:changelog-10.sql

alter table admin alter column id  type bigint;