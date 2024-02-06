--liquibase formatted sql
--changeset test:changelog-1.sql
create sequence "Orders_Order_Id_seq";

alter sequence "Orders_Order_Id_seq" owner to postgres;

create sequence "Shop_Shop_Id_seq";

alter sequence "Shop_Shop_Id_seq" owner to postgres;

create sequence "User_User_Id_seq";

alter sequence "User_User_Id_seq" owner to postgres;

create type status as enum ('FREE', 'BUSY', 'DAY_OFF');

alter type status owner to postgres;

create type status_sale as enum ('DELIVERED', 'IN_TRANSIT', 'ASSEMBLY', 'PAYMENT_VERIFICATION');

alter type status_sale owner to postgres;

create type rating as enum ('5', '4', '3', '2', '1');

alter type rating owner to postgres;

create table client
(
    id           bigint generated always as identity primary key,
    name         varchar(255) not null,
    last_name    varchar(255) not null,
    phone_number varchar(55)  not null,
    email        varchar(255) not null
);

alter table client
    owner to postgres;

alter sequence "User_User_Id_seq" owned by client.id;

create table admin
(
    id        serial primary key,
    name      varchar(255) not null,
    last_name varchar(255) not null,
    email     varchar(255) not null
);

alter table admin
    owner to postgres;

create table courier
(
    id           serial primary key,
    name         varchar(255) not null,
    last_name    varchar(255) not null,
    email        varchar(255) not null,
    phone_number varchar(255)
);

alter table courier
    owner to postgres;

create table product
(
    id         bigint generated always as identity primary key,
    name       varchar(255) not null,
    parameters jsonb
);

alter table product
    owner to postgres;

create table shop
(
    id           bigint generated always as identity primary key,
    name         varchar(255) not null,
    email        varchar(255) not null,
    phone_number varchar(55)  not null
);

alter table shop
    owner to postgres;

alter sequence "Shop_Shop_Id_seq" owned by shop.id;

create table sale
(
    id            bigint generated always as identity primary key,
    delivery_date timestamp,
    address       text,
    client_id     bigint      not null
        constraint client_id_fkey
            references client,
    shop_id       bigint      not null
        constraint shop_fkey
            references shop,
    courier_id    bigint      not null
        constraint courier_fkey
            references courier,
    status        status_sale not null
);

alter table sale
    owner to postgres;

alter sequence "Orders_Order_Id_seq" owned by sale.id;

create table order_product
(
    id         bigint generated always as identity primary key,
    order_id   bigint not null
        constraint order_id_fkey references sale,
    product_id bigint,
    foreign key (product_id) references product (id)
);

alter table order_product
    owner to postgres;

create table shop_rating
(
    id      bigint generated always as identity primary key,
    shop_id bigint not null
        constraint shop_id_fkey references shop (id),
    rating  rating
);

alter table shop_rating
    owner to postgres;
