--liquibase formatted sql
--changeset test:changelog-14.sql

alter table courier alter column id type bigint;