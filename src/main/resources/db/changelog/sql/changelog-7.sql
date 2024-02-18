--liquibase formatted sql
--changeset test:changelog-7.sql

alter table sale alter column "courier_id" drop not null