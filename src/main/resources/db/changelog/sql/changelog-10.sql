--liquibase formatted sql
--changeset test:changelog-10.sql

alter table sale add foreign key (product_id) references product;