--liquibase formatted sql
--changeset test:changelog-14.sql

alter table shop_rating
    alter rating type smallint using rating::text::smallint;

alter table shop_rating
    add constraint check_rating check (rating in (1,2,3,4,5));