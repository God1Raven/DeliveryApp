--liquibase formatted sql
--changeset test:changelog-11.sql

alter table courier alter column id type bigint;